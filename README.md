# pglp_9.9 Logiciel de dessin

![Test Image 4](https://media.istockphoto.com/vectors/scribble-hatching-along-the-square-triangle-and-circle-diagonal-hand-vector-id1130526186)

Logiciel de dessin développé en java mettant en oeuvre les design patter, et se limittant a afficher la descriptions des figures crées.

## Exemple d'utilisation

Pour créer un élément graphique (cercle, carré, rectangle ou un triangle) il faut utliser la commande suivante:

      Nom_Element_Graphique = Type_Element_Graphiqur( les arguments )
      
## Création d'un élément graphique
      
 Exemple de création d'un Cercle, un Carré et un Triangle:
 
 
      cercle1 = Cercle( (2,4), 5) // 5 est le rayon du cercle et (2, 4) les coordonnées du centre
      
      carre1 = Carre( (2,2), (6,6), (3, 3), (7, 7))
      
      triangle1 = Triangle( (2, 4), (3, 5), (2, 7))
      
## Déplacer un élément graphique
      
Pour déplacer un élément graphique il faut utiliser la commande move pour cela, nous avons ci dessous un exemple de déplacement d'un cercle, un carré et un triangle:

      move( cercle1, (2, 4))
      
      move(carre1, (5, 6))
      
      move(triangle1, (4, 6))
     
## Créer un groupe d'éléments graphique

Pour créer un ensemble d'éléments graphique utiliser la syntaxe suivant:

      Nom_Group_Element = group( liste des éléments graphiques )
      
Exemple de création d'un ensemble:

      groupeCercle = group( cercle1, cercle2, cercle3)
      
      groupeCarre = group( carre1, carre2, carre3)
      
      groupeTriangle = group( triangle1, triangle2)
      
 Notez bien, que pour un groupe d'éléments, les éléments qui compose ce groupe doivent etre du même type d'élément graphique,
 mais nous pouvons en plus créer des groupes d'éléments avec des éléments graphique de différent type.
      
 ## Déplacer un groupe d'élément
 
 Pour créer un groupe d'élément, utiliser la syntaxe suivante:
 
      move(Nom_du_group, (a, b))
      
 Le 1er argument étant le nom du groupe, le 2ème élément étant le point qui servira a déplacer l'élément graphique concerné,
 avec a et b étant des entiers.
 
 ## Afficher un élément graphique
 
 Pour afficher un élément graphique, c'est a dire la description de cet élement graphique alors utiliser la commande suivante
 
      affiche( nomGraphique)
      
Il faut préciser le nom du graphique comme argument de la conction affiche. 
Exemple:

                 affiche( c1)
                 affiche(triangle3)
                 
 ## Avoir un guide d'utilisation
 
 Pour avoir un guide d'utilisation de l'application, au lancement de l'application veuiller utiliser la commande help comme ci-dessous:
 
                  help

## Contibution

1. Cloner le projet (https://github.com/uvsq21921901/pglp_9.9)
2. Créer votre branche (`git checkout -b feature/Ajout`)
3. Commiter les changements (`git commit -am 'Add some fooBar'`)
4. Pusher les cha,gements dans votre branche (`git push origin feature/Ajout`)
5. Créer un nouveau Pull Request

<!-- Markdown link & img dfn's -->
[wiki]: https://github.com/uvsq21921901
