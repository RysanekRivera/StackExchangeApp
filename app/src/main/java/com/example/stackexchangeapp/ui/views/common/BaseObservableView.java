package com.example.stackexchangeapp.ui.views.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableView <ListenerType> extends BaseView implements IObservableView<ListenerType> {

    private Set<ListenerType> listeners = new HashSet();

    @Override
    public void registerListener(ListenerType listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        listeners.remove(listener);
    }

    protected Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(listeners);
    }
}
