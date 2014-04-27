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
import net.gtaun.shoebill.common.dialog.InputDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.util.event.EventManager;

public class WlInputDialog extends InputDialog
{
	@SuppressWarnings("unchecked")
	public static abstract class AbstractWlInputDialogBuilder
	<DialogType extends WlInputDialog, DialogBuilderType extends AbstractWlInputDialogBuilder<DialogType, DialogBuilderType>>
	extends AbstractInputDialogBuilder<DialogType, DialogBuilderType>
	{
		protected AbstractWlInputDialogBuilder(DialogType dialog)
		{
			super(dialog);
		}
		
		public DialogBuilderType appendText(String text)
		{
			dialog.setAppendText(text);
			return (DialogBuilderType) this;
		}
		
		public DialogBuilderType appendText(Supplier<String> textSupplier)
		{
			dialog.setAppendText(textSupplier);
			return (DialogBuilderType) this;
		}
		
		public DialogBuilderType appendText(DialogTextSupplier textSupplier)
		{
			dialog.setAppendText(textSupplier);
			return (DialogBuilderType) this;
		}
	}
	
	public static class WlInputDialogBuilder extends AbstractWlInputDialogBuilder<WlInputDialog, WlInputDialogBuilder>
	{
		private WlInputDialogBuilder(Player player, EventManager rootEventManager)
		{
			super(new WlInputDialog(player, rootEventManager));
		}
		
		private WlInputDialogBuilder(Player player, EventManager rootEventManager, boolean passwordMode)
		{
			super(new WlInputDialog(player, rootEventManager, passwordMode));
		}
	}
	
	public static AbstractWlInputDialogBuilder<?, ?> create(Player player, EventManager rootEventManager)
	{
		return new WlInputDialogBuilder(player, rootEventManager);
	}
	
	public static AbstractWlInputDialogBuilder<?, ?> create(Player player, EventManager rootEventManager, boolean passwordMode)
	{
		return new WlInputDialogBuilder(player, rootEventManager, passwordMode);
	}
	
	
	private DialogTextSupplier appendTextSupplier;
	
	
	public WlInputDialog(Player player, EventManager rootEventManager)
	{
		super(player, rootEventManager);
	}

	public WlInputDialog(Player player, EventManager rootEventManager, boolean passwordMode)
	{
		super(player, rootEventManager, passwordMode);
	}

	public WlInputDialog(Player player, EventManager rootEventManager, String caption, String message)
	{
		super(player, rootEventManager, caption, message);
	}
	
	public WlInputDialog(Player player, EventManager rootEventManager, String caption, String message, boolean passwordMode)
	{
		super(player, rootEventManager, caption, message, passwordMode);
	}

	public WlInputDialog(Player player, EventManager rootEventManager, DialogTextSupplier captionSupplier, DialogTextSupplier messageSupplier)
	{
		super(player, rootEventManager, captionSupplier, messageSupplier);
	}
	
	public WlInputDialog(Player player, EventManager rootEventManager, DialogTextSupplier captionSupplier, DialogTextSupplier messageSupplier, boolean passwordMode)
	{
		super(player, rootEventManager, captionSupplier, messageSupplier, passwordMode);
	}
	
	public void setAppendText(String text)
	{
		appendTextSupplier = (d) -> text;
	}
	
	public void setAppendText(Supplier<String> textSupplier)
	{
		appendTextSupplier = (d) -> textSupplier.get();
	}
	
	public void setAppendText(DialogTextSupplier textSupplier)
	{
		appendTextSupplier = textSupplier;
	}
	
	protected void show(String text)
	{
		String append = appendTextSupplier.get(this);
		if (append != null) super.show(text + "\n\n" + append);
		else super.show(text);
	}
	
	@Override
	protected void onClickCancel()
	{
		super.onClickCancel();
		
		player.playSound(1084);
		showParentDialog();	
	}
}
