package com.ouri.java_android_mvp_project.MVP.Main;

import java.util.List;

public interface MainView {
    void displayList(List<Shirt> shirts);
    void clicked(String s);
}
