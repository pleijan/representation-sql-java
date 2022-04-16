package main;

import main.queries.Query;
import main.queries.Tables.*;

import java.io.Console;
import java.util.Objects;
import java.util.Scanner;

import static main.SQL.Make;
import static main.SQL.SQLCOMMANDS.*;

public class InterfaceCLI {

    Scanner s = new Scanner(System.in);

    //constructor
    public InterfaceCLI()
    {
       //while user dont press end , run
        boolean end = false;
        try{
            while(!end)
            {
                AfficherMenu();

                int choix = Integer.parseInt(s.nextLine());
                Query query;

                //switch for each request
                //make the query then call CLI function
                switch (choix)
                {
                    case 0:
                        query = Make(CREATE);
                        CreateCLI((Create)query,true);
                        break;

                    case 1:
                        query = Make(DROP);
                        DropCLI((Drop)query,true);
                        break;

                    case 2:
                        query = Make(CREATE);
                        CreateCLI((Create)query,false);
                        break;

                    case 3:
                        query = Make(DROP);
                        DropCLI((Drop)query,false);
                        break;

                    case 4:
                        query = Make(INSERT);
                        InsertCLI((Insert)query);
                        break;

                    case 5:
                        query = Make(UPDATE);
                        UpdateCLI((Update) query);
                        break;
                    case 6:
                        query = Make(DELETE);
                        DeleteCLI((Delete) query);
                        break;
                    case 7:
                        query = Make(SELECT);
                        SelectCLI((Select) query);
                        break;
                    case 8:
                        end = true;
                        break;
                    default: System.out.println("error !"); return;
                }
            }
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Vous avez essayeer d'entrer un chiffre eu lieu de lettre lors de votre choix ....");
        }
        catch (Exception e){
            System.out.println("Une erreur est survenue !");
            System.out.println(e.getMessage());
        }
    }

    //show the main menu
    public static void AfficherMenu()
    {
        System.out.println("Selectionner une option parmis les suivantes : ");
        System.out.println("0) Créer une base de donnée");
        System.out.println("1) Supprimer une base de donnée");
        System.out.println("2) Créer une table ");
        System.out.println("3) Supprimer une table ");
        System.out.println("4) Insérer une donnée ");
        System.out.println("5) Modifier ( update ) une donnée ");
        System.out.println("6) Supprimer ( delete ) une donnée ");
        System.out.println("7) Selectionner ( select ) une donnée ");
        System.out.println("8) quitter... ");
    }

    //select Request CLI interface
    public void SelectCLI(Select select)
    {
        int choix;
        System.out.println("Entrez le nom de la table :");
        String tableName = s.nextLine();
        select.from(tableName);

        System.out.println("Entrez le nom de du champ a selectionner dans la table :");
        String champ = s.nextLine();
        select.select(champ);

        System.out.println("voulez-vous ajouter un join ? si oui cliquez sur 1 , sinon sur 2");
        choix =  Integer.parseInt(s.nextLine());

        //add join
        if(choix == 1)
        {
            System.out.println("Entrez le type de join ( INNER, LEFT...) :");
            String type = s.nextLine();
            System.out.println("Entrez le nom de la jointure :");
            String secondTable = s.nextLine();
            System.out.println("Entrez le nom du premier champ joint :");
            String firstField = s.nextLine();
            System.out.println("Entrez l'operateur pour la jointure ( + = < ..) : ");
            String operator = s.nextLine();
            System.out.println("Entrez le nom du second champ joint :");
            String secondField = s.nextLine();
            select.join(type,secondTable,firstField,secondField,operator);
        }

        System.out.println("voulez-vous ajouter un where ? si oui cliquez sur 1 , sinon sur 2");
        choix =  Integer.parseInt(s.nextLine());

        //add where
        if(choix == 1)
        {
            System.out.println("Entrez l'attribu ou le champ de la condition : ");
            String attribute = s.nextLine();
            System.out.println("Entrez l'operateur :");
            String operator = s.nextLine();
            System.out.println("Entrez la valeur ou le champ comparé :");
            String value = s.nextLine();
            select.where(attribute,operator,value);
        }

        System.out.println("voulez vous ajouter un group by ? si oui cliquez sur 1 , sinon sur 2");
        choix =  Integer.parseInt(s.nextLine());

        //add grouby
        if(choix == 1)
        {
            System.out.println("Entrez le champ par lequel grouper : ");
            String attribute = s.nextLine();
            select.groupBy(attribute);
        }

        System.out.println("voulez vous ajouter un order by ? si oui cliquez sur 1 , sinon sur 2");
        choix =  Integer.parseInt(s.nextLine());

        //add orderby
        if(choix == 1)
        {
            System.out.println("Entrez le champ par lequel ordonner : ");
            String attribute = s.nextLine();
            System.out.println("Entrez ASC ou DESC : ");
            String asc = s.nextLine();
            select.orderBy(attribute,asc);
        }
        System.out.println(select.printQuery());
    }

    //insert function
    public void InsertCLI(Insert insert)
    {
        int choix;
        System.out.println("Entrez le nom de la table :");
        String tableName = s.nextLine();
        insert.from(tableName);

        System.out.println("Entrez le nom de la colone pour l'insertion : ");
        String col = s.nextLine();
        System.out.println("Entrez le nom de la valeur pour l'insertion : ");
        String val = s.nextLine();
        insert.insert(col,val);

        System.out.println(insert.printQuery());
    }

    //update function
    public void UpdateCLI(Update update)
    {
        int choix;
        System.out.println("Entrez le nom de la table :");
        String tableName = s.nextLine();
        update.from(tableName);

        System.out.println("Entrez le nom de la colone pour la modification : ");
        String col = s.nextLine();
        System.out.println("Entrez la nouvelle valeur  : ");
        String val = s.nextLine();
        update.update(col,val);

        System.out.println("voulez-vous ajouter un where ? si oui cliquez sur 1 , sinon sur 2");
        choix =  Integer.parseInt(s.nextLine());

        //add where
        if(choix == 1)
        {
            System.out.println("Entrez l'attribu ou le champ de la condition : ");
            String attribute = s.nextLine();
            System.out.println("Entrez l'operateur :");
            String operator = s.nextLine();
            System.out.println("Entrez la valeur ou le champ comparé :");
            String value = s.nextLine();
            update.where(attribute,operator,value);
        }

        System.out.println(update.printQuery());
    }

    //drop function CLI
    public void DropCLI(Drop drop, boolean isDataBase)
    {
        int choix;
        String name;

        if(isDataBase)
        {
            System.out.println("Entrez le nom de la base de données :");
            name = s.nextLine();
            drop.addName(name);
            drop.addState(true);
        }
        else
        {
            System.out.println("Entrez le nom de la table :");
            name = s.nextLine();
            drop.addName(name);
            drop.addState(false);
        }

        System.out.println(drop.printQuery());
    }

    //Create function CLI
    public void CreateCLI(Create create, boolean isDataBase)
    {
        int choix;
        String name;

        if(isDataBase)
        {
            System.out.println("Entrez le nom de la base de données :");
            name = s.nextLine();
            create.addName(name);
            create.addState(true);
        }
        else
        {
            System.out.println("Entrez le nom de la nouvelle table :");
            name = s.nextLine();
            create.addName(name);
            create.addState(false);

            System.out.println("Entrez le nom d'une colone :");
            String col = s.nextLine();
            System.out.println("Entrez le datatype de la colone :");
            String dataType = s.nextLine();
            System.out.println("le champs est-il null ? : 1) oui 2) non :");
            int nullableChoix = Integer.parseInt(s.nextLine());
            boolean nullable = nullableChoix != 2;

            create.addColumn(col,dataType,nullable);
        }

        System.out.println(create.printQuery());
    }

    //delete fucntion CLI
    public void DeleteCLI(Delete delete)
    {
        int choix;
        System.out.println("Entrez le nom de la table ou on veux supprimer une donnée :");
        String tableName = s.nextLine();
        delete.from(tableName);

        System.out.println("voulez-vous ajouter un where ? si oui cliquez sur 1 , sinon sur 2");
        choix =  Integer.parseInt(s.nextLine());

        //ad where
        if(choix == 1)
        {
            System.out.println("Entrez l'attribu ou le champ de la condition : ");
            String attribute = s.nextLine();
            System.out.println("Entrez l'operateur :");
            String operator = s.nextLine();
            System.out.println("Entrez la valeur ou le champ comparé :");
            String value = s.nextLine();
            delete.where(attribute,operator,value);
        }

        System.out.println(delete.printQuery());
    }
}
