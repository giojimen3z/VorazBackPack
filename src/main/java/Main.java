import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Element elements[];
        int ElementWeight = 0;
        int ElementBenefit = 0;
        int BackWeight = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese el peso de la mochila"));
        int BackElements = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese la cantidad de elementos maxima que tendra la mochila la mochila"));
        String ChainsOfElement = "";


        elements = new git initElement[BackElements];

        for (int i = 0; i < elements.length; i++) {
            int element = i + 1;

            ElementWeight = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese el peso del elemento  # " + element));
            ElementBenefit = Integer.parseInt(JOptionPane.showInputDialog(null, "por favor ingrese el beneficio del elemento  # " + element));
            elements[i] = new Element(ElementWeight, ElementBenefit);
        }

        BackPack BackPackBase = new BackPack(BackWeight, elements.length);
        BackPack BackPackOptimized = new BackPack(BackWeight, elements.length);


        FillBackpack(BackPackBase, elements, false, BackPackOptimized);

        for (int i = 0; i < elements.length; i++) {
            int element2 = i + 1;

            ChainsOfElement = ChainsOfElement + "El elemento #"+ element2 +" Contiene:\n Peso: "+ elements[i].getWeight() + "\n Beneficio: " + elements[i].getBenefit() + "\n";

        }
        System.out.println(ChainsOfElement);
        System.out.println(BackPackOptimized);
    }

    public static void FillBackpack(BackPack BackPackBase, Element[] elements, boolean full, BackPack BackPackOptimized) {

        //si esta llena
        if (full) {
            //compruebo si tiene mas beneficio que otra
            if (BackPackBase.getBenefit() > BackPackOptimized.getBenefit()) {

                Element[] elementsBase = BackPackBase.getElements();
                BackPackOptimized.clear();

                //metemos los elementos
                for (Element e : elementsBase) {
                    if (e != null) {
                        BackPackOptimized.AddElement(e);
                    }

                }

            }

        } else {
            //Recorre los elementos
            for (int i = 0; i < elements.length; i++) {
                //si existe el elemento
                if (!BackPackBase.ElementExist(elements[i])) {
                    //Si el peso de la mochila se supera, indicamos que esta llena
                    if (BackPackBase.getMaxWeight() >= BackPackBase.getWeight() + elements[i].getWeight()) {
                        BackPackBase.AddElement(elements[i]); //añadimos
                        FillBackpack(BackPackBase, elements, false, BackPackOptimized);
                        BackPackBase.DeleteElement(elements[i]); // lo eliminamos
                    } else {
                        FillBackpack(BackPackBase, elements, true, BackPackOptimized);
                    }

                }

            }

        }

    }

}