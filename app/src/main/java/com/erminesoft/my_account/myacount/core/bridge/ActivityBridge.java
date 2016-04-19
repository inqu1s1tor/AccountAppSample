package com.erminesoft.my_account.myacount.core.bridge;

import com.erminesoft.my_account.myacount.core.AAplication;
import com.erminesoft.my_account.myacount.ui.FragmentLauncher;

/**
 * Created by Aleks on 19.04.2016.
 */
public interface ActivityBridge {

    AAplication getUApplication();

    FragmentLauncher getFragmentLauncher();
}
