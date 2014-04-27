/**
 * WL Common Library
 * Copyright (C) 2013 MK124
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.gtaun.wl.common.textdraw;

import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerTextdraw;

import org.apache.commons.lang3.StringUtils;

public final class TextDrawUtils
{
	public static PlayerTextdraw createPlayerText(Player player, float x, float y, String text)
	{
		PlayerTextdraw textdraw = PlayerTextdraw.create(player, x, (y-50)/1.075f+50, text);
		return textdraw;
	}
	
	public static PlayerTextdraw createPlayerTextBG(Player player, float x, float y, float w, float h)
	{
		int lines = Math.round((h - 5) / 5.0f);
		PlayerTextdraw textdraw = PlayerTextdraw.create(player, x+4, (y-50)/1.075f+50, StringUtils.repeat("~n~", lines));
		textdraw.setUseBox(true);
		textdraw.setLetterSize(0.1f, 0.5f);
		textdraw.setTextSize(x+w-4, h-7);
		return textdraw;
	}
	
	public static String convertCharacters(String src)
	{
		String dest = src;
		dest = dest.replace('Ä', 'ƒ');
		dest = dest.replace('ä', 'š');
		dest = dest.replace('Ö', '‘');
		dest = dest.replace('ö', '¨');
		dest = dest.replace('Ü', '•');
		dest = dest.replace('ü', '¬');
		dest = dest.replace('ß', '–');
		return dest;
	}
	
	private TextDrawUtils()
	{
		
	}
}
