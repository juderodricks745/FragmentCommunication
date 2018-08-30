package com.davidbronn.fragmentrevision.fragment_states;

public interface FragmentStarter {
    void ender();
    void locateHome();
    void startFragment(boolean addfragment, boolean backstack, int position);
}
