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

package lsi.sma.controleur;

import lsi.sma.modele.AgentArbitre;
import lsi.sma.modele.AgentJoueur;
import lsi.sma.modele.AgentTerrain;
import jade.core.AID;

import java.awt.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class AgentHandler {

    protected CopyOnWriteArrayList<GameObject> objects = new CopyOnWriteArrayList<>();

    private Set<AID> equipe1 = new HashSet<>();

    private Set<AID> equipe2 = new HashSet<>();
    private AID arbitreId;
    private AID terrainId;
    private AgentTerrain terrain;
    private AID gardienEquipe1;
    private AID gardienEquipe2;

    public AID getArbitreId() {
        return arbitreId;
    }

    public void setArbitreId(AID arbitreId) {
        this.arbitreId = arbitreId;
    }

    public CopyOnWriteArrayList<GameObject> getObjects() {
        return objects;
    }

    /**
     * Rendu de tous les agents
     */
    public void render(Graphics g) {
        if (terrain != null)
            terrain.render(g);
        objects.forEach(agent -> agent.render(g));
    }

    /**
     * Lancement du match
     */
    public void startMatch() {
        if (arbitreId != null) {
            objects.stream().filter(go -> go.getAID() == arbitreId).forEach(go -> {
                AgentArbitre arbitre = (AgentArbitre) go;
                arbitre.sifflerCoupDEnvoi();
            });
        }
    }

    public AID getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(AID terrainId) {
        this.terrainId = terrainId;
    }

    @Deprecated
    public AgentTerrain getTerrain() {
        return terrain;
    }

    @Deprecated
    public void setTerrain(AgentTerrain at) {
        terrain = at;
    }

    public Stream<AID> getJoueursIds() {
        return Stream.concat(equipe1.stream(), equipe2.stream());
    }

    public void ajouteJoueur(AID joueurAID, int numeroEquipe) {
        if (numeroEquipe == 1)
            equipe1.add(joueurAID);
        else
            equipe2.add(joueurAID);
    }

    /**
     * TODO A remplacer par des �changes de messages entre agents
     *
     * @param id
     * @return
     */
    @Deprecated
    public AgentJoueur getJoueur(AID id) {
        Optional<GameObject> gameObject = objects.stream().filter(j -> j.getAID() == id).findFirst();
        return (AgentJoueur) gameObject.orElse(null);
    }

    public AID getGardienId(int numeroEquipeGardien) {
        if (numeroEquipeGardien == 1)
            return gardienEquipe1;
        else
            return gardienEquipe2;
    }

    public void ajouteGardien(AID aid, int numeroEquipe) {
        if (numeroEquipe == 1)
            this.gardienEquipe1 = aid;
        else
            this.gardienEquipe2 = aid;
    }

    /**
     * TODO A remplacer par des �changes de messages entre agents
     *
     * @param id
     * @return
     */



    /**
     * TODO A remplacer par des �changes de messages entre agents
     *
     * @param id
     * @return
     */
    @Deprecated
    public AgentArbitre getArbitre(AID id) {
        Optional<GameObject> gameObject = objects.stream().filter(a -> a.getAID() == id).findFirst();
        return (AgentArbitre) gameObject.orElse(null);
    }

    public void stopMatch() {
        if (terrain != null)
            terrain.doDelete();
        objects.forEach(agent -> agent.doDelete());
    }
}
