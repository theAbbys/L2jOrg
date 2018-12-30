package org.l2j.gameserver.data.xml.holder;

import java.util.Collection;

import org.l2j.commons.data.xml.AbstractHolder;
import org.l2j.gameserver.templates.premiumaccount.PremiumAccountTemplate;

import io.github.joealisson.primitive.maps.IntObjectMap;
import io.github.joealisson.primitive.maps.impl.TreeIntObjectMap;

public class PremiumAccountHolder extends AbstractHolder
{
	private static final PremiumAccountHolder _instance = new PremiumAccountHolder();

	private static final PremiumAccountTemplate DEFAULT_ACCOUNT_TEMPLATE = new PremiumAccountTemplate(0);

	private final IntObjectMap<PremiumAccountTemplate> _premiumAccounts = new TreeIntObjectMap<PremiumAccountTemplate>();

	public static PremiumAccountHolder getInstance()
	{
		return _instance;
	}

	public void addPremiumAccount(PremiumAccountTemplate premiumAccount)
	{
		_premiumAccounts.put(premiumAccount.getType(), premiumAccount);
	}

	public PremiumAccountTemplate getPremiumAccount(int type)
	{
		if(type == 0 && !_premiumAccounts.containsKey(type))
			return DEFAULT_ACCOUNT_TEMPLATE;
		return _premiumAccounts.get(type);
	}

	public Collection<PremiumAccountTemplate> getPremiumAccounts()
	{
		return _premiumAccounts.values();
	}

	@Override
	public int size()
	{
		return _premiumAccounts.size();
	}

	@Override
	public void clear()
	{
		_premiumAccounts.clear();
	}
}