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

import net.gtaun.shoebill.common.dialog.ListDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public class WlListDialog extends ListDialog
{
	public static abstract class AbstractWlListDialogBuilder
	<DialogType extends WlListDialog, DialogBuilderType extends AbstractWlListDialogBuilder<DialogType, DialogBuilderType>>
	extends AbstractListDialogBuilder<DialogType, DialogBuilderType>
	{
		protected AbstractWlListDialogBuilder(DialogType dialog)
		{
			super(dialog);
		}
	}
	
	public static class WlListDialogBuilder extends AbstractWlListDialogBuilder<WlListDialog, WlListDialogBuilder>
	{
		private WlListDialogBuilder(Player player, EventManager rootEventManager)
		{
			super(new WlListDialog(player, rootEventManager));
		}
	}
	
	public static AbstractWlListDialogBuilder<?, ?> create(Player player, EventManager rootEventManager)
	{
		return new WlListDialogBuilder(player, rootEventManager);
	}
	
	
	protected WlListDialog(Player player, EventManager eventManager)
	{
		super(player, eventManager);
	}
	
	@Override
	protected void onClickCancel()
	{
		super.onClickCancel();
		
		player.playSound(1084);
		showParentDialog();	
	}
}
