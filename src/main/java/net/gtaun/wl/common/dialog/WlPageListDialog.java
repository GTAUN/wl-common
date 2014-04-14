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

package net.gtaun.wl.common.dialog;

import net.gtaun.shoebill.common.dialog.PageListDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public abstract class WlPageListDialog extends PageListDialog
{
	protected WlPageListDialog(Player player, EventManager eventManager)
	{
		super(player, eventManager);
		setPageTurnHandler((d) -> player.playSound(1083, player.getLocation()));
		setClickCancelHandler((d) ->
		{
			player.playSound(1084, player.getLocation());
			showParentDialog();
		});
	}
}
