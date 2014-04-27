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

public class WlPageListDialog extends PageListDialog
{
	public static abstract class AbstractWlPageListDialogBuilder
	<DialogType extends WlPageListDialog, DialogBuilderType extends AbstractWlPageListDialogBuilder<DialogType, DialogBuilderType>>
	extends AbstractPageListDialogBuilder<DialogType, DialogBuilderType>
	{
		protected AbstractWlPageListDialogBuilder(DialogType dialog)
		{
			super(dialog);
		}
	}
	
	public static class WlPageListDialogBuilder extends AbstractWlPageListDialogBuilder<WlPageListDialog, WlPageListDialogBuilder>
	{
		private WlPageListDialogBuilder(Player player, EventManager rootEventManager)
		{
			super(new WlPageListDialog(player, rootEventManager));
		}
	}
	
	public static AbstractWlPageListDialogBuilder<?, ?> create(Player player, EventManager rootEventManager)
	{
		return new WlPageListDialogBuilder(player, rootEventManager);
	}
	
	
	protected WlPageListDialog(Player player, EventManager eventManager)
	{
		super(player, eventManager);
	}
	
	@Override
	public void onPageTurn()
	{
		super.onPageTurn();
		player.playSound(1083);
	}
	
	@Override
	protected void onClickCancel()
	{
		super.onClickCancel();
		
		player.playSound(1084);
		showParentDialog();	
	}
}
