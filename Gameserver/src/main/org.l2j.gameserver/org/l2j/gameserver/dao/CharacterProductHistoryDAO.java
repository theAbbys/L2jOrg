package org.l2j.gameserver.dao;

import org.l2j.commons.database.L2DatabaseFactory;
import org.l2j.commons.dbutils.DbUtils;
import org.l2j.gameserver.data.xml.holder.ProductDataHolder;
import org.l2j.gameserver.model.Player;
import org.l2j.gameserver.model.actor.instances.player.ProductHistoryItem;
import org.l2j.gameserver.templates.item.product.ProductItem;
import io.github.joealisson.primitive.maps.IntObjectMap;
import io.github.joealisson.primitive.maps.impl.HashIntObjectMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Bonux
 */
public class CharacterProductHistoryDAO
{
	private static final Logger _log = LoggerFactory.getLogger(CharacterProductHistoryDAO.class);

	private static final CharacterProductHistoryDAO _instance = new CharacterProductHistoryDAO();

	public static CharacterProductHistoryDAO getInstance()
	{
		return _instance;
	}

	public IntObjectMap<ProductHistoryItem> select(Player owner)
	{
		IntObjectMap<ProductHistoryItem> map = new HashIntObjectMap<ProductHistoryItem>();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rset = null;
		try
		{
			con = L2DatabaseFactory.getInstance().getConnection();
			statement = con.prepareStatement("SELECT product_id, last_purchase_time FROM character_product_history WHERE char_id = ?");
			statement.setInt(1, owner.getObjectId());
			rset = statement.executeQuery();
			while(rset.next())
			{
				int product_id = rset.getInt("product_id");
				int last_purchase_time = rset.getInt("last_purchase_time");

				ProductItem product = ProductDataHolder.getInstance().getProduct(product_id);
				if(product == null)
					continue;

				map.put(product_id, new ProductHistoryItem(product, last_purchase_time));
			}
		}
		catch(Exception e)
		{
			_log.error("CharacterProductHistoryDAO.select(Player): " + e, e);
		}
		finally
		{
			DbUtils.closeQuietly(con, statement, rset);
		}
		return map;
	}

	public boolean replace(Player owner, ProductHistoryItem item)
	{
		Connection con = null;
		PreparedStatement statement = null;
		try
		{
			con = L2DatabaseFactory.getInstance().getConnection();
			statement = con.prepareStatement("REPLACE INTO character_product_history (char_id,product_id,last_purchase_time) VALUES(?,?,?)");
			statement.setInt(1, owner.getObjectId());
			statement.setInt(2, item.getProduct().getId());
			statement.setInt(3, item.getLastPurchaseTime());
			statement.execute();
		}
		catch(Exception e)
		{
			_log.warn(owner.getBlockList() + " could not add item to premium item list: " + item, e);
			return false;
		}
		finally
		{
			DbUtils.closeQuietly(con, statement);
		}
		return true;
	}
}