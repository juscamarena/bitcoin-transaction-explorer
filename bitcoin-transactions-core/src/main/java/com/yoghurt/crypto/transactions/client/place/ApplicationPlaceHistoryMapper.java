package com.yoghurt.crypto.transactions.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ StartupPlace.Tokenizer.class, TransactionPlace.Tokenizer.class, BlockPlace.Tokenizer.class })
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapper {}
