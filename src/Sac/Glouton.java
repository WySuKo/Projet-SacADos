package Sac;
import Sac.*;
import java.util.*;
import static java.util.Collections.*;

public class Glouton {

    public float rapport (Objet obj){
        return obj.getValeur()/obj.getPoids();
    }

 /*Cette fonction prend le dernier élément comme pivot, place
   l'élément de pivot à sa position correcte dans le tableau trié
   , et place tous les plus petits (plus petit que pivot)
   à gauche du pivot et tous les plus grands éléments à droite
   de pivot
        public int partition(ArrayList<Objet> objets, int low, int high)
        {

            // pivot
            Objet pivot = objets.get(high);

            // Index du plus petit élément
            // et indique la bonne position
            // du pivot trouvé jusqu'à présent
            int i = (low - 1);

            for(int j = low; j <= high - 1; j++)
            {

                // If current element is smaller
                // than the pivot
                if (objets[j] < pivot)
                {

                    // Increment index of
                    // smaller element
                    i++;
                    swap(objets, i, j);
                }
            }
            swap(objets, i + 1, high);
            return (i + 1);
        }

 The main function that implements QuickSort
          arr[] --> Array to be sorted,
          low --> Starting index,
          high --> Ending index

        /*public void quickSort(int[] arr, int low, int high)
        {
            if (low < high)
            {

                // pi is partitioning index, arr[p]
                // is now at right place
                int pi = partition(arr, low, high);

                // Separately sort elements before
                // partition and after partition
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

// Function to print an array
        public void printArray(int[] arr, int size)
        {
            for(int i = 0; i < size; i++)
                System.out.print(arr[i] + " ");

            System.out.println();
        }

  */
    }
