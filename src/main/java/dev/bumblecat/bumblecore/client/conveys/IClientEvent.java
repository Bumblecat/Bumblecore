package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;
import dev.bumblecat.bumblecore.common.conveys.IEvent;

interface IClientEvent extends IEvent {

    IClientWindow getWindow();
}
