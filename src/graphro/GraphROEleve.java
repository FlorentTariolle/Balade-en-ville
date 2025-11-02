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
     * @param metroActif true si le métro fonctionne, false sinon
     * @return le graphe complet de la ville
     */
    public static GrapheListe creerGrapheVille(boolean metroActif) {
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
        
        // Arêtes du métro : seulement si le métro fonctionne
        if (metroActif) {
            graphe.ajouterArc(arretMetroJaune, arretMetroRouge, 1);
            graphe.ajouterArc(arretMetroRouge, arretMetroJaune, 1);
            graphe.ajouterArc(arretMetroRouge, arretMetroVert, 1);
            graphe.ajouterArc(arretMetroVert, arretMetroRouge, 1);
        }
        
        return graphe;
    }
    
    /**
     * Crée le graphe de la ville avec le métro fonctionnel (méthode de compatibilité)
     * @return le graphe complet de la ville
     */
    public static GrapheListe creerGrapheVille() {
        return creerGrapheVille(true);
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
        
        for (Sommet u : sommets) {
            Integer indexU = sommetToIndex.get(u);
            if (indexU == null) continue;
            
            for (Sommet v : sommets) {
                if (u != v) {
                    Integer indexV = sommetToIndex.get(v);
                    if (indexV == null) continue;
                    
                    int distance = distances[indexU][indexV];
                    
                    if (distance != Integer.MAX_VALUE) {
                        grapheComplet.ajouterArc(u, v, distance);
                    }
                }
            }
        }
        
        return grapheComplet;
    }
    
    /**
     * Résout le problème du voyageur de commerce (TSP) avec l'algorithme de Held-Karp
     * Visite toutes les "villes" spécifiées en partant et revenant au dépôt
     * 
     * @param grapheComplet le graphe complet valué
     * @param villesAVisiter liste des "villes" à visiter (incluant le dépôt au début et à la fin)
     * @param sommetToIndex map des sommets vers leurs indices
     * @return le coût minimal et le chemin optimal
     */
    public static int[] heldKarp(GrapheListe grapheComplet, List<Sommet> villesAVisiter, Map<Sommet, Integer> sommetToIndex) {
        int n = villesAVisiter.size();
        
        // Créer une matrice de distances entre les "villes" à visiter
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Sommet u = villesAVisiter.get(i);
            LinkedList<Arc> voisins = grapheComplet.voisins(u);
            Map<Sommet, Integer> distances = new HashMap<>();
            for (Arc arc : voisins) {
                distances.put(arc.destination(), arc.valeur());
            }
            
            for (int j = 0; j < n; j++) {
                Sommet v = villesAVisiter.get(j);
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    Integer d = distances.get(v);
                    dist[i][j] = (d != null) ? d : Integer.MAX_VALUE;
                }
            }
        }
        
        // dp[mask][j] = coût minimal pour visiter toutes les "villes" dans mask et finir à j
        int totalSubsets = 1 << n;
        int[][] dp = new int[totalSubsets][n];
        int[][] parent = new int[totalSubsets][n];
        
        // Initialiser avec des valeurs infinies
        for (int i = 0; i < totalSubsets; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            Arrays.fill(parent[i], -1);
        }
        
        // Base : partir du dépôt
        dp[1 << 0][0] = 0;
        
        // Remplir la table DP
        for (int mask = 1; mask < totalSubsets; mask++) {
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) continue; // j n'est pas dans mask
                if (dp[mask][j] == Integer.MAX_VALUE) continue;
                
                // Essayer d'ajouter chaque "ville" non visitée
                for (int k = 0; k < n; k++) {
                    if ((mask & (1 << k)) != 0) continue; // k déjà dans mask
                    if (dist[j][k] == Integer.MAX_VALUE) continue;
                    
                    int newMask = mask | (1 << k);
                    int newCost = dp[mask][j] + dist[j][k];
                    
                    if (newCost < dp[newMask][k]) {
                        dp[newMask][k] = newCost;
                        parent[newMask][k] = j;
                    }
                }
            }
        }
        
        // Trouver le meilleur coût en revenant au dépôt
        int fullMask = (1 << n) - 1;
        int minCost = Integer.MAX_VALUE;
        int lastCity = -1;
        
        for (int j = 0; j < n; j++) {
            if (dp[fullMask][j] == Integer.MAX_VALUE) continue;
            int cost = dp[fullMask][j] + dist[j][0]; // Revenir au dépôt
            if (cost < minCost && dist[j][0] != Integer.MAX_VALUE) {
                minCost = cost;
                lastCity = j;
            }
        }
        
        // Reconstruire le chemin
        List<Integer> cheminIndices = new ArrayList<>();
        int currentMask = fullMask;
        int currentCity = lastCity;
        
        // Ajouter la dernière ville
        cheminIndices.add(0, currentCity);
        
        // Remonter jusqu'au départ
        while (currentMask != (1 << 0)) {
            int prevCity = parent[currentMask][currentCity];
            if (prevCity == -1) break;
            cheminIndices.add(0, prevCity);
            currentMask = currentMask ^ (1 << currentCity);
            currentCity = prevCity;
        }
        
        // Ajouter le retour au dépôt à la fin
        cheminIndices.add(0);
        
        // Créer le résultat
        int[] result = new int[cheminIndices.size() + 2];
        result[0] = minCost;
        result[1] = cheminIndices.size();
        for (int i = 0; i < cheminIndices.size(); i++) {
            result[i + 2] = cheminIndices.get(i);
        }
        
        return result;
    }

    /**
     * Résout le TSP pour un graphe donné et affiche les résultats
     */
    private static void resoudreTSP(GrapheListe grapheVille, String scenario) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SCÉNARIO : " + scenario);
        System.out.println("=".repeat(60));
        
        System.out.println("\n=== Calcul des distances minimales (BFS répété) ===");
        int[][] distances = calculerDistancesMinimales(grapheVille);
        
        Collection<Sommet> sommets = grapheVille.sommets();
        
        // Créer une map des sommets vers leurs indices
        Map<Sommet, Integer> sommetToIndex = new HashMap<>();
        int idx = 0;
        for (Sommet s : sommets) {
            sommetToIndex.put(s, idx);
            idx++;
        }
        
        System.out.println("\n=== Création du graphe complet valué ===");
        GrapheListe grapheComplet = creerGrapheCompletValue(grapheVille, distances, sommetToIndex);
        System.out.println("Graphe complet créé avec " + grapheComplet.taille() + " sommets");
        
        System.out.println("\n=== Résolution du TSP avec Held-Karp ===");
        // Trouver les sommets à visiter
        List<Sommet> villesAVisiter = new ArrayList<>();
        Sommet depot = null;
        Sommet adresse8 = null;
        Sommet adresse10 = null;
        Sommet adresse22 = null;
        Sommet adresse3 = null;
        
        for (Sommet s : grapheComplet.sommets()) {
            String nom = s.toString();
            if (nom.equals("depot_rue_bleu")) {
                depot = s;
            } else if (nom.equals("8_rue_mauve")) {
                adresse8 = s;
            } else if (nom.equals("10_rue_rouge")) {
                adresse10 = s;
            } else if (nom.equals("22_rue_vert")) {
                adresse22 = s;
            } else if (nom.equals("3_rue_marron")) {
                adresse3 = s;
            }
        }
        
        if (depot != null && adresse8 != null && adresse10 != null && adresse22 != null && adresse3 != null) {
            villesAVisiter.add(depot);
            villesAVisiter.add(adresse8);
            villesAVisiter.add(adresse10);
            villesAVisiter.add(adresse22);
            villesAVisiter.add(adresse3);
            
            System.out.println("Villes à visiter :");
            for (Sommet v : villesAVisiter) {
                System.out.println("  - " + v);
            }
            
            int[] result = heldKarp(grapheComplet, villesAVisiter, sommetToIndex);
            
            if (result[0] != Integer.MAX_VALUE) {
                System.out.println("\n✓ SOLUTION TROUVÉE");
                System.out.println("Coût minimal : " + result[0]);
                System.out.println("Chemin optimal :");
                for (int i = 2; i < result.length; i++) {
                    int villeIdx = result[i];
                    System.out.println("  " + (i - 1) + ". " + villesAVisiter.get(villeIdx));
                }
            } else {
                System.out.println("\n✗ Aucune solution trouvée (certaines villes ne sont pas accessibles)");
            }
        } else {
            System.out.println("Erreur : impossible de trouver toutes les villes à visiter");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Création du graphe de la ville ===");
        GrapheListe grapheVilleAvecMetro = creerGrapheVille(true);
        
        System.out.println("Nombre de sommets : " + grapheVilleAvecMetro.taille());
        System.out.println("\nListe des sommets :");
        for (Sommet s : grapheVilleAvecMetro.sommets()) {
            System.out.println("  - " + s);
        }
        
        // Résoudre avec métro
        resoudreTSP(grapheVilleAvecMetro, "AVEC MÉTRO (fonctionnel)");
        
        // Résoudre sans métro
        System.out.println("\n\n");
        GrapheListe grapheVilleSansMetro = creerGrapheVille(false);
        resoudreTSP(grapheVilleSansMetro, "SANS MÉTRO (panne)");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("COMPARAISON DES RÉSULTATS");
        System.out.println("=".repeat(60));
        System.out.println("\nLes résultats montrent l'impact de la panne du métro sur l'itinéraire optimal.");
        System.out.println("Voir le document PDF pour les détails des modifications apportées au code.");
    }
}
