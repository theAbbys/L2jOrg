package org.l2j.gameserver.data.xml.holder;

import org.l2j.commons.data.xml.AbstractHolder;
import org.l2j.gameserver.templates.OptionDataTemplate;
import io.github.joealisson.primitive.maps.IntObjectMap;
import io.github.joealisson.primitive.maps.impl.HashIntObjectMap;

/**
 * @author VISTALL
 * @date 20:35/19.05.2011
 */
public final class OptionDataHolder extends AbstractHolder
{
	private static final OptionDataHolder _instance = new OptionDataHolder();

	private IntObjectMap<OptionDataTemplate> _templates = new HashIntObjectMap<OptionDataTemplate>();

	public static OptionDataHolder getInstance()
	{
		return _instance;
	}

	public void addTemplate(OptionDataTemplate template)
	{
		_templates.put(template.getId(), template);
	}

	public OptionDataTemplate getTemplate(int id)
	{
		return _templates.get(id);
	}

	@Override
	public int size()
	{
		return _templates.size();
	}

	@Override
	public void clear()
	{
		_templates.clear();
	}
}