package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class LearningSystem {

    ArrayList<Institution> institutions = new ArrayList<Institution>();

    public void addInstitution(Institution institution) {
        this.institutions.add(institution);
    }

    public void printSortedByDate() {
        Collections.sort(institutions, Institution.InstitutionDateComperator);

        System.out.println(" - Institutions sorted by date \n");
        for(Institution str: this.institutions){
            System.out.println(str);
        }
    }

    public void printSortedByCount() {
        Collections.sort(institutions, Institution.InstitutionStudentsCountComperator);

        System.out.println(" - Institutions sorted by students count\n");
        for (Institution str : this.institutions) {
            System.out.println(str);
        }
    }

    public ArrayList<Institution> getSortedByCount () {
        Collections.sort(institutions, Institution.InstitutionStudentsCountComperator);

        return new ArrayList<Institution>(this.institutions);
    }

    public ArrayList<Institution> getSortedByDate () {
        Collections.sort(institutions, Institution.InstitutionDateComperator);

        return new ArrayList<Institution>(this.institutions);
    }

    public ArrayList<Institution> getInstitutions() {
        return this.institutions;
    }
}
