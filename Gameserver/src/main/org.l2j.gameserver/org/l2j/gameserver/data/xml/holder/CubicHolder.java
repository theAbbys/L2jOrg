package org.l2j.gameserver.data.xml.holder;

import org.l2j.commons.data.xml.AbstractHolder;
import org.l2j.gameserver.templates.CubicTemplate;
import io.github.joealisson.primitive.maps.impl.HashIntObjectMap;

/**
 * @author VISTALL
 * @date  15:15/22.12.2010
 */
public final class CubicHolder extends AbstractHolder
{
	private static CubicHolder _instance = new CubicHolder();
	private final HashIntObjectMap<CubicTemplate> _cubics = new HashIntObjectMap<CubicTemplate>(10);

	public static CubicHolder getInstance()
	{
		return _instance;
	}

	private CubicHolder()
	{}

	public void addCubicTemplate(CubicTemplate template)
	{
		_cubics.put(hash(template.getId(), template.getLevel()), template);
	}

	public CubicTemplate getTemplate(int id, int level)
	{
		return _cubics.get(hash(id, level));
	}

	public int hash(int id, int level)
	{
		return id * 10000 + level;
	}

	@Override
	public int size()
	{
		return _cubics.size();
	}

	@Override
	public void clear()
	{
		_cubics.clear();
	}
}