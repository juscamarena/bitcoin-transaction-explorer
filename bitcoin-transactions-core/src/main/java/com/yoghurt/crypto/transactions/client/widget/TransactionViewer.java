package com.yoghurt.crypto.transactions.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.yoghurt.crypto.transactions.client.ui.TransactionView.Presenter;
import com.yoghurt.crypto.transactions.client.util.TransactionPartColorPicker;
import com.yoghurt.crypto.transactions.shared.domain.TransactionPartType;
import com.yoghurt.crypto.transactions.shared.util.ArrayUtil;

public class TransactionViewer extends ValueViewer {
  private final ClickHandler mouseClickHandler = new ClickHandler() {
    @Override
    public void onClick(final ClickEvent event) {
      placeController.goTo(value);
    }
  };
  private final TransactionPlaceRouter placeController;

  /**
   * Flag indicating whether or not the value is LE or BE, if it's BE, will convert to LE
   */
  private final boolean reverse;

  public TransactionViewer(final Presenter presenter, final boolean coinbase) {
    this(presenter, true, coinbase);
  }

  public TransactionViewer(final TransactionPlaceRouter placeRouter, final boolean reverse, final boolean coinbase) {
    super(TransactionPartColorPicker.getFieldColor(TransactionPartType.TRANSACTION_HASH), new SimpleContextFactory<String>() {
      @Override
      protected String getTextValue(final String value) {
        if(coinbase) {
          return "This is a coinbase transaction, it has no inputs.";
        } else {
          return "View this transaction.";
        }
      }
    });

    this.placeController = placeRouter;
    this.reverse = reverse;

    if(!coinbase) {
      setMouseClickHandler(mouseClickHandler);
    }
  }

  @Override
  public void setValue(final byte[] hash) {
    if (reverse) {
      ArrayUtil.reverse(hash);
    }

    super.setValue(hash);
  }
}
