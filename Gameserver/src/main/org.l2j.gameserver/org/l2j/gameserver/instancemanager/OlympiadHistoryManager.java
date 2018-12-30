package org.l2j.gameserver.instancemanager;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.l2j.gameserver.dao.OlympiadHistoryDAO;
import org.l2j.gameserver.data.string.StringsHolder;
import org.l2j.gameserver.model.Player;
import org.l2j.gameserver.model.entity.Hero;
import org.l2j.gameserver.model.entity.olympiad.OlympiadHistory;
import org.l2j.gameserver.network.l2.components.HtmlMessage;
import org.l2j.gameserver.templates.StatsSet;
import org.l2j.gameserver.utils.HtmlUtils;
import io.github.joealisson.primitive.pair.IntObjectPair;
import io.github.joealisson.primitive.maps.IntObjectMap;
import io.github.joealisson.primitive.maps.impl.CHashIntObjectMap;

import static org.l2j.commons.util.Util.STRING_EMPTY;

/**
 * @author VISTALL
 * @date 20:32/02.05.2011
 */
public class OlympiadHistoryManager
{
	private static final OlympiadHistoryManager _instance = new OlympiadHistoryManager();

	private IntObjectMap<List<OlympiadHistory>> _historyNew = new CHashIntObjectMap<List<OlympiadHistory>>();
	private IntObjectMap<List<OlympiadHistory>> _historyOld = new CHashIntObjectMap<List<OlympiadHistory>>();

	public static OlympiadHistoryManager getInstance()
	{
		return _instance;
	}

	OlympiadHistoryManager()
	{
		Map<Boolean, List<OlympiadHistory>> historyList = OlympiadHistoryDAO.getInstance().select();
		for(Map.Entry<Boolean, List<OlympiadHistory>> entry : historyList.entrySet())
			for(OlympiadHistory history : entry.getValue())
				addHistory(entry.getKey(), history);
	}

	/**
	 * Старую за преведущих 2 месяца удаляет, а за преведущий
	 */
	public void switchData()
	{
		_historyOld.clear();

		_historyOld.putAll(_historyNew);

		_historyNew.clear();

		OlympiadHistoryDAO.getInstance().switchData();
	}

	public void saveHistory(OlympiadHistory history)
	{
		addHistory(false, history);

		OlympiadHistoryDAO.getInstance().insert(history);
	}

	public void addHistory(boolean old, OlympiadHistory history)
	{
		IntObjectMap<List<OlympiadHistory>> map = old ? _historyOld : _historyNew;

		addHistory0(map, history.getObjectId1(), history);
		addHistory0(map, history.getObjectId2(), history);
	}

	private void addHistory0(IntObjectMap<List<OlympiadHistory>> map, int objectId, OlympiadHistory history)
	{
		List<OlympiadHistory> historySet = map.get(objectId);
		if(historySet == null)
			map.put(objectId, historySet = new CopyOnWriteArrayList<OlympiadHistory>());

		historySet.add(history);
	}

	public void showHistory(Player player, int targetClassId, int page)
	{
		final int perpage = 15;

		IntObjectPair<StatsSet> entry = Hero.getInstance().getHeroStats(targetClassId);
		if(entry == null)
			return;

		List<OlympiadHistory> historyList = _historyOld.get(entry.getKey());
		if(historyList == null)
			historyList = Collections.emptyList();

		HtmlMessage html = new HtmlMessage(5);
		html.setFile("olympiad/monument_hero_info.htm");
		html.replace("%title%", StringsHolder.getInstance().getString(player, "hero.history"));

		int allStatWinner = 0;
		int allStatLoss = 0;
		int allStatTie = 0;
		for(OlympiadHistory h : historyList)
		{
			if(h.getGameStatus() == 0)
				allStatTie++;
			else
			{
				int team = entry.getKey() == h.getObjectId1() ? 1 : 2;
				if(h.getGameStatus() == team)
					allStatWinner++;
				else
					allStatLoss++;
			}
		}
		html.replace("%wins%", String.valueOf(allStatWinner));
		html.replace("%ties%", String.valueOf(allStatTie));
		html.replace("%losses%", String.valueOf(allStatLoss));

		int min = perpage * (page - 1);
		int max = perpage * page;

		int currentWinner = 0;
		int currentLoss = 0;
		int currentTie = 0;

		final StringBuilder b = new StringBuilder(500);

		for(int i = 0; i < historyList.size(); i++)
		{
			OlympiadHistory history = historyList.get(i);
			if(history.getGameStatus() == 0)
				currentTie++;
			else
			{
				int team = entry.getKey() == history.getObjectId1() ? 1 : 2;
				if(history.getGameStatus() == team)
					currentWinner++;
				else
					currentLoss++;
			}

			if(i < min)
				continue;

			if(i >= max)
				break;

			b.append("<tr><td>");
			b.append(history.toString(player, entry.getKey(), currentWinner, currentLoss, currentTie));
			b.append("</td></tr");
		}

		if(min > 0)
		{
			html.replace("%buttprev%", HtmlUtils.PREV_BUTTON);
			html.replace("%prev_bypass%", "_match?class=" + targetClassId + "&page=" + (page - 1));
		}
		else
			html.replace("%buttprev%", STRING_EMPTY);

		if(historyList.size() > max)
		{
			html.replace("%buttnext%", HtmlUtils.NEXT_BUTTON);
			html.replace("%next_bypass%", "_match?class=" + targetClassId + "&page=" + (page + 1));
		}
		else
			html.replace("%buttnext%", STRING_EMPTY);

		html.replace("%list%", b.toString());

		player.sendPacket(html);
	}
}