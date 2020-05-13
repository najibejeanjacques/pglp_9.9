# pglp_9.9

[![NPM Version][npm-image]][npm-url]
[![Build Status][travis-image]][travis-url]
[![Downloads Stats][npm-downloads]][npm-url]

Logiciel de dessin est un projet en java mettant en place les pattern design en oeuvre et se limittant a afficher la descriptions des figures crées

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
     

## Meta

Your Name – [@YourTwitter](https://twitter.com/dbader_org) – YourEmail@example.com

Distributed under the XYZ license. See ``LICENSE`` for more information.

[https://github.com/yourname/github-link](https://github.com/dbader/)

## Contibution

1. Cloner le projet (https://github.com/uvsq21921901/pglp_9.9)
2. Créer votre branche (`git checkout -b feature/fooBar`)
3. Commiter les changements (`git commit -am 'Add some fooBar'`)
4. Pusher les cha,gements dans votre branche (`git push origin feature/fooBar`)
5. Créer un nouveau Pull Request

<!-- Markdown link & img dfn's -->
[wiki]: https://github.com/uvsq21921901
