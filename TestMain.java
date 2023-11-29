import java.util.Random;
public class TestMain {
final static int NB_ELEM = 10000;  // taille de=u tableau d'éléments
  final static int K = 1000000; // constante pour génerer aleatoirement
  final static int NB_ELEM2 = 1000; // taille du tableau ASUPPRIMER
  // méthode static pour remplissage aleatoires du tableau
    public static Element[] remplirAlea(int taille) {
        Random r = new Random();
          Element[] tab = new Element[taille];
            for(int i = 0 ; i<taille ; i++ )
           {
                tab[i] = new Element(r.nextInt(K + 1),i) ;
           }
        return tab ;
    }

    
public static void main(String[] args) {
System.out.println("**********************Les premiers tests qui ont été effectués sur les méthodes*******************************");

ArbreBinaire abr = new ArbreBinaire();
        abr.ajout(new Element(12, 1.3));
        abr.ajout(new Element(25, 2.1));
        abr.ajout(new Element(7, 3.6));
        abr.ajout(new Element(9, 4.3));
        abr.ajout(new Element(11, 5.2));
        abr.ajout(new Element(4, 6.8));
        abr.ajout(new Element(1, 7.4));
        System.out.println("Affichage de l'arbre binaire de recherche :");
        abr.afficheInfixeEtHauteur();
        Noeud n1 = abr.recherche(11, abr.getRacine());
        Noeud n2 = abr.recherche(4, abr.getRacine());
        Noeud n3 = abr.recherche(13, abr.getRacine());
        System.out.println("Recherche de la clé 11 : " + (n1 != null ? n1.getElement() : "Clé non trouvée"));
        System.out.println("Recherche de la clé 4 : " + (n2 != null ? n2.getElement() : "Clé non trouvée"));
        System.out.println("Recherche de la clé 13 : " + (n3 != null ? n3.getElement() : "Clé non trouvée"));
        abr.supprimer(new Element(1, 7.4));
        abr.ajout(new Element(5, 112));
        abr.ajout(new Element(20, 123));
        abr.ajout(new Element(22, 320));
        abr.supprimer(new Element(12, 1.3));
        System.out.println("Affichage de l'arbre binaire de recherche après suppressions et insertions :");
        abr.afficheInfixeEtHauteur();
    
    System.out.println("********************** tester l’efficacité pratique des méthodes ajout et suppression*******************************");

ArbreBinaire arbre = new ArbreBinaire();
Element[] tab = remplirAlea(NB_ELEM);
Random r = new Random();
Element[] ASUPPRIMER = new Element[NB_ELEM2];
for(int i = 0 ; i<NB_ELEM2 ; i++ )
{
    ASUPPRIMER[i] = new Element();
}
//insertion dans l'arbre et remplissage de ASUPPRIMER
int j = 0;
long debutAjout = System.nanoTime();
for(int i = 0 ; i<NB_ELEM ; i++ )
{
    arbre.ajout(tab[i]);
    //tirage pour le tablea ASSUPPRIMER avec la probabilité donnée
    if (r.nextDouble() < 0.15 && j < NB_ELEM2) {
        ASUPPRIMER[j] = tab[i];
        j++;
    }
}
long finAjout = System.nanoTime();
System.out.println("Temps d'insertion des elements du  tableau est de  : " + (finAjout - debutAjout) + " ns");
//System.out.println("Arbre apres l'insertion sans doublons ");

System.out.println(" ----------Effectuer 1000 insertions supplémentaires --------");
long debutAjout0 = System.nanoTime();
for(int k=0; k<NB_ELEM2 ; k++)
{
    arbre.ajout(new Element(r.nextInt(1000000 + 1),k));
}
long finAjout0 = System.nanoTime();
System.out.println("Temps d'insertion des 1000 elements : " + (finAjout0 - debutAjout0) + " ns");
//arbre.afficheInfixeEtHauteur();
// AFFICHAGE DU TABLEAU SUPPRESSION
for(int K=0; K<NB_ELEM2 ; K++)
{
    System.out.println(ASUPPRIMER[K]) ;
}
System.out.println("\n  ----------Supprimer les 1000 élements qui vient du tableau ASUPPRIMER --------");
long debutSuppression = System.nanoTime();
for(int K=0; K<NB_ELEM2 ; K++)
{
    arbre.supprimer(ASUPPRIMER[K]) ;
}
long finSuppression = System.nanoTime();
System.out.println(" Temps de suppression pour ABR : " + (finSuppression - debutSuppression) + " ns");
//arbre.afficheInfixeEtHauteur() ;





System.out.println(" ----------------------------------------------ListeChainee-----------------------------------------------------");


ListeChainee liste = new ListeChainee();
for(int i = 0 ; i<NB_ELEM2 ; i++ )
{
    ASUPPRIMER[i] = new Element();
}
//insertion dans l'arbre et remplissage de ASUPPRIMER

long debut = System.nanoTime();
for(int i = 0 ; i<NB_ELEM ; i++ )
{
    liste.ajouteTete(tab[i]);
    //tirage pour le tablea ASSUPPRIMER avec la probabilité donnée
    if (r.nextDouble() < 0.15 && j < NB_ELEM2) {
        ASUPPRIMER[j] = tab[i];
        j++;
    }
}
long fin = System.nanoTime();
System.out.println("Temps d'insertion des elements du  tableau est de  : " + (fin - debut) + " ns");
//System.out.println("Arbre apres l'insertion sans doublons ");
//arbre.Afficher();
System.out.println(" ----------Effectuer 1000 insertions supplémentaires --------");
long debut0 = System.nanoTime();
for(int k=0; k<NB_ELEM2 ; k++)
{
    arbre.ajout(new Element(r.nextInt(1000000 + 1),k));
}
long fin0 = System.nanoTime();
System.out.println("Temps d'insertion des 1000 elements : " + (fin0 - debut0) + " ns");
//arbre.afficheInfixeEtHauteur();
// AFFICHAGE DU TABLEAU SUPPRESSION
for(int K=0; K<NB_ELEM2 ; K++)
{
    System.out.println(ASUPPRIMER[K]) ;
}
System.out.println("\n  ----------Supprimer les 1000 élements qui vient du tableau ASUPPRIMER --------");
long debut1 = System.nanoTime();
for(int K=0; K<NB_ELEM2 ; K++)
{
    liste.retirer(ASUPPRIMER[K]) ;
}
long fin1 = System.nanoTime();
System.out.println(" Temps de suppression pour ABR : " + (fin1 - debut1) + " ns");
//arbre.afficheInfixeEtHauteur() ;
}
}