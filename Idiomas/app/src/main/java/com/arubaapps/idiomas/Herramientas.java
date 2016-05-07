package com.arubaapps.idiomas;

/**
 * Created by Antonio_2 on 07/05/2016.
 */
public class Herramientas {
    private static Usuario yo = new Usuario();

    public static Usuario getYo() {
        return yo;
    }

    public static void setYo(Usuario yo) {
        Herramientas.yo = yo;
    }
}
