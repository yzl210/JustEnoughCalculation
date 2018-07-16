package me.towdium.jecalculation.network.packets;

import io.netty.buffer.ByteBuf;
import me.towdium.jecalculation.data.ControllerClient;
import me.towdium.jecalculation.data.structure.User;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PRecord implements IMessage, IMessageHandler<PRecord, IMessage> {
    User user;

    public PRecord(User user) {
        this.user = user;
    }

    public PRecord() {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        NBTTagCompound tag = ByteBufUtils.readTag(buf);
        user = new User(tag == null ? new NBTTagCompound() : tag);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, user.serialize());
    }

    @Override
    public IMessage onMessage(PRecord message, MessageContext ctx) {
        ControllerClient.syncFromServer(message.user);
        return null;
    }
}