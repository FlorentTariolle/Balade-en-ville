/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphro;

import java.util.*;

/**
 * Classe principale pour le problème de livraison optimale
 * 
 * @author gdelmondo
 */
public class GraphROEleve {

    /**
     * Crée le graphe de la ville avec tous les sommets et arêtes
     * @return le graphe complet de la ville
     */
    public static GrapheListe creerGrapheVille() {
        // Création du graphe avec 22 sommets
        GrapheListe graphe = new GrapheListe(22);
        
        // Création de tous les sommets
        Sommet arretMetroJaune = new Sommet("arret_metro_rue_jaune", 0);
        Sommet interJauneMauve = new Sommet("intersection_jaune_mauve", 0);
        Sommet adresse8RueMauve = new Sommet("8_rue_mauve", 0);
        Sommet interMauveVert = new Sommet("intersection_mauve_vert", 0);
        Sommet interMauveNoir = new Sommet("intersection_mauve_noir", 0);
        Sommet interNoirCyan = new Sommet("intersection_noir_cyan", 0);
        Sommet interCyanRouge = new Sommet("intersection_cyan_rouge", 0);
        Sommet interRougeVert = new Sommet("intersection_rouge_vert", 0);
        Sommet adresse10RueRouge = new Sommet("10_rue_rouge", 0);
        Sommet interRougeOrange = new Sommet("intersection_rouge_orange", 0);
        Sommet interOrangeNoir = new Sommet("intersection_orange_noir", 0);
        Sommet interNoirRose = new Sommet("intersection_noir_rose", 0);
        Sommet interRoseGris = new Sommet("intersection_rose_gris", 0);
        Sommet interGrisVert = new Sommet("intersection_gris_vert", 0);
        Sommet interNoirVert = new Sommet("intersection_noir_vert", 0);
        Sommet arretMetroRouge = new Sommet("arret_metro_rouge", 0);
        Sommet arretMetroVert = new Sommet("arret_metro_vert", 0);
        Sommet adresse22RueVert = new Sommet("22_rue_vert", 0);
        Sommet interVertMarron = new Sommet("intersection_vert_marron", 0);
        Sommet interMarronBleu = new Sommet("intersection_marron_bleu", 0);
        Sommet depotRueBleu = new Sommet("depot_rue_bleu", 0); // 5 rue bleu
        Sommet adresse3RueMarron = new Sommet("3_rue_marron", 0);
        
        // Ajout des sommets au graphe
        graphe.ajouterSommet(arretMetroJaune);
        graphe.ajouterSommet(interJauneMauve);
        graphe.ajouterSommet(adresse8RueMauve);
        graphe.ajouterSommet(interMauveVert);
        graphe.ajouterSommet(interMauveNoir);
        graphe.ajouterSommet(interNoirCyan);
        graphe.ajouterSommet(interCyanRouge);
        graphe.ajouterSommet(interRougeVert);
        graphe.ajouterSommet(adresse10RueRouge);
        graphe.ajouterSommet(interRougeOrange);
        graphe.ajouterSommet(interOrangeNoir);
        graphe.ajouterSommet(interNoirRose);
        graphe.ajouterSommet(interRoseGris);
        graphe.ajouterSommet(interGrisVert);
        graphe.ajouterSommet(interNoirVert);
        graphe.ajouterSommet(arretMetroRouge);
        graphe.ajouterSommet(arretMetroVert);
        graphe.ajouterSommet(adresse22RueVert);
        graphe.ajouterSommet(interVertMarron);
        graphe.ajouterSommet(interMarronBleu);
        graphe.ajouterSommet(depotRueBleu);
        graphe.ajouterSommet(adresse3RueMarron);
        
        // Ajout des arêtes : deux sommets sont reliés s'ils sont sur la même rue
        // Les arêtes sont non orientées (on ajoute dans les deux sens)
        // Valeur de l'arc = 1 (distance unitaire entre deux sommets consécutifs)
        
        graphe.ajouterArc(arretMetroJaune, interJauneMauve, 1);
        graphe.ajouterArc(interJauneMauve, arretMetroJaune, 1);
        graphe.ajouterArc(interRougeOrange, interOrangeNoir, 1);
        graphe.ajouterArc(interOrangeNoir, interRougeOrange, 1);
        
        graphe.ajouterArc(interJauneMauve, adresse8RueMauve, 1);
        graphe.ajouterArc(adresse8RueMauve, interJauneMauve, 1);
        graphe.ajouterArc(adresse8RueMauve, interMauveVert, 1);
        graphe.ajouterArc(interMauveVert, adresse8RueMauve, 1);
        graphe.ajouterArc(interJauneMauve, interMauveNoir, 1);
        graphe.ajouterArc(interMauveNoir, interJauneMauve, 1);
        
        graphe.ajouterArc(interCyanRouge, arretMetroRouge, 1);
        graphe.ajouterArc(arretMetroRouge, interCyanRouge, 1);
        graphe.ajouterArc(interCyanRouge, interRougeOrange, 1);
        graphe.ajouterArc(interRougeOrange, interCyanRouge, 1);
        graphe.ajouterArc(interRougeVert, adresse10RueRouge, 1);
        graphe.ajouterArc(adresse10RueRouge, interRougeVert, 1);
        graphe.ajouterArc(adresse10RueRouge, arretMetroRouge, 1);
        graphe.ajouterArc(arretMetroRouge, adresse10RueRouge, 1);
        
        graphe.ajouterArc(interMauveVert, interRougeVert, 1);
        graphe.ajouterArc(interRougeVert, interMauveVert, 1);
        graphe.ajouterArc(interMauveVert, adresse22RueVert, 1);
        graphe.ajouterArc(adresse22RueVert, interMauveVert, 1);
        graphe.ajouterArc(interGrisVert, interNoirVert, 1);
        graphe.ajouterArc(interNoirVert, interGrisVert, 1);
        graphe.ajouterArc(interGrisVert, adresse22RueVert, 1);
        graphe.ajouterArc(adresse22RueVert, interGrisVert, 1);
        graphe.ajouterArc(interVertMarron, arretMetroVert, 1);
        graphe.ajouterArc(arretMetroVert, interVertMarron, 1);
        graphe.ajouterArc(interNoirVert, arretMetroVert, 1);
        graphe.ajouterArc(arretMetroVert, interNoirVert, 1);
        
        graphe.ajouterArc(interMauveNoir, interNoirCyan, 1);
        graphe.ajouterArc(interNoirCyan, interMauveNoir, 1);
        graphe.ajouterArc(interOrangeNoir, interNoirCyan, 1);
        graphe.ajouterArc(interNoirCyan, interOrangeNoir, 1);
        graphe.ajouterArc(interOrangeNoir, interNoirRose, 1);
        graphe.ajouterArc(interNoirRose, interOrangeNoir, 1);
        graphe.ajouterArc(interNoirRose, interNoirVert, 1);
        graphe.ajouterArc(interNoirVert, interNoirRose, 1);
        
        graphe.ajouterArc(interNoirCyan, interCyanRouge, 1);
        graphe.ajouterArc(interCyanRouge, interNoirCyan, 1);
        
        graphe.ajouterArc(interNoirRose, interRoseGris, 1);
        graphe.ajouterArc(interRoseGris, interNoirRose, 1);
        
        graphe.ajouterArc(interRoseGris, interGrisVert, 1);
        graphe.ajouterArc(interGrisVert, interRoseGris, 1);
        
        graphe.ajouterArc(interVertMarron, interMarronBleu, 1);
        graphe.ajouterArc(interMarronBleu, interVertMarron, 1);
        graphe.ajouterArc(interMarronBleu, adresse3RueMarron, 1);
        graphe.ajouterArc(adresse3RueMarron, interMarronBleu, 1);
        
        graphe.ajouterArc(interMarronBleu, depotRueBleu, 1);
        graphe.ajouterArc(depotRueBleu, interMarronBleu, 1);
        
        graphe.ajouterArc(arretMetroJaune, arretMetroRouge, 1);
        graphe.ajouterArc(arretMetroRouge, arretMetroJaune, 1);
        graphe.ajouterArc(arretMetroRouge, arretMetroVert, 1);
        graphe.ajouterArc(arretMetroVert, arretMetroRouge, 1);
        
        return graphe;
    }
    
    /**
     * Effectue un BFS depuis un sommet source pour calculer les distances minimales
     * vers tous les autres sommets
     * 
     * @param graphe le graphe
     * @param source le sommet source
     * @param sommetToIndex map des sommets vers leurs indices dans la matrice de distances
     * @param indexToSommet map inverse des indices vers les sommets
     * @return un tableau des distances minimales depuis source vers tous les sommets
     */
    public static int[] bfs(GrapheListe graphe, Sommet source, Map<Sommet, Integer> sommetToIndex, Map<Integer, Sommet> indexToSommet) {
        int n = graphe.taille();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialiser avec l'infini
        
        // Trouver l'index du sommet source
        Integer sourceIndex = sommetToIndex.get(source);
        if (sourceIndex == null) {
            return distances;
        }
        
        // File FIFO pour le BFS
        Queue<Integer> file = new LinkedList<>();
        Set<Integer> visite = new HashSet<>();
        
        distances[sourceIndex] = 0;
        file.offer(sourceIndex);
        visite.add(sourceIndex);
        
        while (!file.isEmpty()) {
            int u = file.poll();
            
            // Trouver le sommet correspondant à l'index u
            Sommet sommetU = indexToSommet.get(u);
            if (sommetU == null) continue;
            
            // Parcourir tous les voisins
            LinkedList<Arc> voisins = graphe.voisins(sommetU);
            for (Arc arc : voisins) {
                Sommet v = arc.destination();
                Integer vIndex = sommetToIndex.get(v);
                
                if (vIndex != null && !visite.contains(vIndex)) {
                    visite.add(vIndex);
                    distances[vIndex] = distances[u] + 1; // Distance = nombre d'arêtes
                    file.offer(vIndex);
                }
            }
        }
        
        return distances;
    }
    
    /**
     * Calcule la matrice des distances minimales entre tous les sommets
     * en appliquant un BFS depuis chaque sommet (Repeated BFS)
     * 
     * @param graphe le graphe
     * @return une matrice V x V des distances minimales (distances[i][j] = distance de i à j)
     */
    public static int[][] calculerDistancesMinimales(GrapheListe graphe) {
        Collection<Sommet> sommets = graphe.sommets();
        int n = graphe.taille();
        int[][] distances = new int[n][n];
        
        // Initialiser la matrice : diagonale à 0, reste à l'infini
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // Créer une map des sommets vers leurs indices et l'inverse
        Map<Sommet, Integer> sommetToIndex = new HashMap<>();
        Map<Integer, Sommet> indexToSommet = new HashMap<>();
        int index = 0;
        for (Sommet s : sommets) {
            sommetToIndex.put(s, index);
            indexToSommet.put(index, s);
            index++;
        }
        
        // BFS depuis chaque sommet
        for (Sommet source : sommets) {
            int[] dists = bfs(graphe, source, sommetToIndex, indexToSommet);
            int sourceIndex = sommetToIndex.get(source);
            for (int j = 0; j < n; j++) {
                distances[sourceIndex][j] = dists[j];
            }
        }
        
        return distances;
    }
    
    /**
     * Crée un graphe complet valué où chaque arête (u,v) a pour valeur la distance minimale
     * entre u et v dans le graphe original
     * 
     * @param grapheOriginal le graphe original
     * @param distances la matrice des distances minimales entre tous les sommets
     * @param sommetToIndex map des sommets vers leurs indices dans la matrice de distances
     * @return un graphe complet valué avec les mêmes sommets
     */
    public static GrapheListe creerGrapheCompletValue(GrapheListe grapheOriginal, int[][] distances, Map<Sommet, Integer> sommetToIndex) {
        Collection<Sommet> sommets = grapheOriginal.sommets();
        int n = sommets.size();
        
        // Créer le nouveau graphe avec les mêmes sommets
        GrapheListe grapheComplet = new GrapheListe(n);
        
        // Ajouter tous les sommets
        for (Sommet s : sommets) {
            grapheComplet.ajouterSommet(s);
        }
        
        // Ajouter toutes les arêtes entre toutes les paires de sommets
        // Chaque arête est valuée par la distance minimale entre les deux sommets
        for (Sommet u : sommets) {
            Integer indexU = sommetToIndex.get(u);
            if (indexU == null) continue;
            
            for (Sommet v : sommets) {
                if (u != v) { // Pas de boucle
                    Integer indexV = sommetToIndex.get(v);
                    if (indexV == null) continue;
                    
                    int distance = distances[indexU][indexV];
                    // Ne pas ajouter d'arête si la distance est infinie
                    if (distance != Integer.MAX_VALUE) {
                        grapheComplet.ajouterArc(u, v, distance);
                    }
                }
            }
        }
        
        return grapheComplet;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Création du graphe de la ville ===");
        GrapheListe grapheVille = creerGrapheVille();
        
        System.out.println("Nombre de sommets : " + grapheVille.taille());
        System.out.println("\nListe des sommets :");
        for (Sommet s : grapheVille.sommets()) {
            System.out.println("  - " + s);
        }
        
        System.out.println("\n=== Calcul des distances minimales (BFS répété) ===");
        int[][] distances = calculerDistancesMinimales(grapheVille);
        
        System.out.println("\nMatrice des distances minimales :");
        Collection<Sommet> sommets = grapheVille.sommets();
        
        // Créer une map des sommets vers leurs indices pour l'affichage
        Map<Sommet, Integer> sommetToIndex = new HashMap<>();
        int idx = 0;
        for (Sommet s : sommets) {
            sommetToIndex.put(s, idx);
            idx++;
        }
        
        System.out.println("\n=== Création du graphe complet valué ===");
        GrapheListe grapheComplet = creerGrapheCompletValue(grapheVille, distances, sommetToIndex);
        System.out.println("Graphe complet créé avec " + grapheComplet.taille() + " sommets");
        
        // Compter le nombre d'arêtes
        int nbAretes = 0;
        for (Sommet s : grapheComplet.sommets()) {
            nbAretes += grapheComplet.voisins(s).size();
        }
        System.out.println("Nombre d'arêtes : " + nbAretes);
        
        // Afficher l'en-tête
        System.out.print("        ");
        for (Sommet s : sommets) {
            System.out.printf("%8s", s.toString().substring(0, Math.min(8, s.toString().length())));
        }
        System.out.println();
        
        // Afficher la matrice
        for (Sommet s1 : sommets) {
            int i = sommetToIndex.get(s1);
            System.out.printf("%8s", s1.toString().substring(0, Math.min(8, s1.toString().length())));
            for (Sommet s2 : sommets) {
                int j = sommetToIndex.get(s2);
                if (distances[i][j] == Integer.MAX_VALUE) {
                    System.out.printf("%8s", "INF");
                } else {
                    System.out.printf("%8d", distances[i][j]);
                }
            }
            System.out.println();
        }
    }
}
