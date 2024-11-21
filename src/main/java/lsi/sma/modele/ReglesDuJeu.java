/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Arthur Lefebvre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package lsi.sma.modele;

import java.awt.*;

public abstract class ReglesDuJeu {
    public static final int NBJOUEURS = 8;
    public static final Color COULEUR_GARDIENS = Color.BLACK;
    public static final Color COULEUR_EQUIPE_1 = Color.RED;
    public static final Color COULEUR_EQUIPE_2 = Color.BLUE;
    public static final Color COULEUR_ARBITRE = Color.YELLOW;
    public static final int TAILLE_JOUEUR = 20;
    public static final int TAILLE_BALLON = 12;
    public static final int TAILLE_ARBITRE = TAILLE_JOUEUR;
    public static final int LARGEUR_TERRAIN = 400;
    public static final int LONGUEUR_TERRAIN = 600;
    public static final Position MILIEU_DE_TERRAIN = new Position(LONGUEUR_TERRAIN / 2, LARGEUR_TERRAIN / 2);
    public static final Position BUT_EQUIPE_1 = new Position(25, MILIEU_DE_TERRAIN.getY());
    public static final Position BUT_EQUIPE_2 = new Position(LONGUEUR_TERRAIN - 25, MILIEU_DE_TERRAIN.getY());
    public static final double SEUIL_PROXIMITE = 10;
}
