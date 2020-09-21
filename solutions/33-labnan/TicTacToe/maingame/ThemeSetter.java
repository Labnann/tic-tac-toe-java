package maingame;

import maingame.UI.Themeable;
import maingame.theme.ClassicTheme;
import maingame.theme.Theme;

import java.util.ArrayList;

public class ThemeSetter {
    private ArrayList<Themeable> themeables = new ArrayList<>();
    private Theme theme = new ClassicTheme();

    public void add(Themeable themeable) {
        this.themeables.add(themeable);
    }

    public Theme getCurrentTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        for (Themeable themeable : themeables) {
            themeable.setTheme(theme);
        }
    }
}
