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

import java.util.function.Supplier;

import net.gtaun.shoebill.common.dialog.DialogTextSupplier;
import net.gtaun.shoebill.common.dialog.MsgboxDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public class WlMsgboxDialog extends MsgboxDialog
{
	public static abstract class AbstractWlMsgboxDialogBuilder
	<DialogType extends WlMsgboxDialog, DialogBuilderType extends AbstractWlMsgboxDialogBuilder<DialogType, DialogBuilderType>>
	extends AbstractMsgboxDialogBuilder<DialogType, DialogBuilderType>
	{
		protected AbstractWlMsgboxDialogBuilder(DialogType dialog)
		{
			super(dialog);
		}
	}
	
	public static class WlMsgboxDialogBuilder extends AbstractWlMsgboxDialogBuilder<WlMsgboxDialog, WlMsgboxDialogBuilder>
	{
		private WlMsgboxDialogBuilder(Player player, EventManager rootEventManager)
		{
			super(new WlMsgboxDialog(player, rootEventManager));
		}
	}
	
	public static AbstractWlMsgboxDialogBuilder<?, ?> create(Player player, EventManager rootEventManager)
	{
		return new WlMsgboxDialogBuilder(player, rootEventManager);
	}
	
	
	protected String message;
	

	protected WlMsgboxDialog(Player player, EventManager rootEventManager)
	{
		super(player, rootEventManager);
		init();
	}
	
	public WlMsgboxDialog(Player player, EventManager rootEventManager, String caption, String message)
	{
		super(player, rootEventManager, caption, message);
		init();
	}
	
	public WlMsgboxDialog(Player player, EventManager rootEventManager, Supplier<String> captionSupplier, Supplier<String> messageSupplier)
	{
		super(player, rootEventManager, captionSupplier, messageSupplier);
		init();
	}
	
	public WlMsgboxDialog(Player player, EventManager rootEventManager, DialogTextSupplier captionSupplier, DialogTextSupplier messageSupplier)
	{
		super(player, rootEventManager, captionSupplier, messageSupplier);
		init();
	}
	
	private void init()
	{
		setClickCancelHandler((d) ->
		{
			player.playSound(1084, player.getLocation());
			showParentDialog();
		});
	}
	
	@Override
	public void show()
	{
		show(message);
	}
}
