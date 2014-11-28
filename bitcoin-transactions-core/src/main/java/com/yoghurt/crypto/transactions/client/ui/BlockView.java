package com.yoghurt.crypto.transactions.client.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.yoghurt.crypto.transactions.shared.domain.Block;
import com.yoghurt.crypto.transactions.shared.domain.BlockInformation;

public interface BlockView extends IsWidget {

  public interface Presenter {

  }

  void setBlock(Block transaction);

  void setBlockInformation(BlockInformation transactionInformation);

  void setPresenter(Presenter presenter);
}
