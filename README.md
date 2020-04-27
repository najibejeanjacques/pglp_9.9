# pglp_9.9

1) Proposer et implémenter une hiérarchie de classe représentant les formes graphiques:

On crée notre interface graphique:

    public interface graphique
    {
          public void getDescription();
    }
    
Puis on crée les différents objets qu'on pourra manipuler:

    public class Cercle implements graphique
    {
          private String description;
          
          @Override
          public void getDescription()
          {
          }
    }
    
    public class Carre implements graphique
    {
          private String description;
          
          @Override
          public void getDescription()
          {
          }
    }
    
    
      public class Rectangle implements graphique
      {
          private String description;
          
          @Override
          public void getDescription()
          {
          }
      }
    
        public class Triangle implements graphique
        {
          private String description;
          
          @Override
          public void getDescription()
          {
          }
        }
        
   On implemente une classe qui pourra ajouter plusieurs élements a une composition:
   
      public class graphiqueComposite implements graphique
      {
            private Colection children;
            
            public graphiqueComposite()
            {
                children = new ArrayList();
            }
            
            public void add(graphique graph)
            {
              children.add(graph);
            }
            
            public void remove(graphique graph)
            {
              children.remove(graph);
            }
      }
