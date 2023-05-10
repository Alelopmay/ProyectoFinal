package org.example.Domain;

import java.time.LocalDate;

public class MarkRecord {
   private swimmer Cod_Swimmer;
   private trialSwimmer Id;

   private int ID_Marckrecord;
   private double Time;
   private LocalDate Date;

   public MarkRecord(swimmer cod_Swimmer, trialSwimmer id, int ID_Marckrecord, double time, LocalDate date) {
      Cod_Swimmer = cod_Swimmer;
      Id = id;
      this.ID_Marckrecord = ID_Marckrecord;
      Time = time;
      Date = date;
   }

   public MarkRecord() {

   }

   public swimmer getCod_Swimmer() {
      return Cod_Swimmer;
   }

   public void setCod_Swimmer(swimmer cod_Swimmer) {
      Cod_Swimmer = cod_Swimmer;
   }

   public trialSwimmer getId() {
      return Id;
   }

   public void setId(trialSwimmer id) {
      Id = id;
   }

   public int getID_Marckrecord() {
      return ID_Marckrecord;
   }

   public void setID_Marckrecord(int ID_Marckrecord) {
      this.ID_Marckrecord = ID_Marckrecord;
   }

   public double getTime() {
      return Time;
   }

   public void setTime(double time) {
      Time = time;
   }

   public LocalDate getDate() {
      return Date;
   }

   public void setDate(LocalDate date) {
      Date = date;
   }

   @Override
   public String toString() {
      return "MarkRecord{" +
              "Cod_Swimmer=" + Cod_Swimmer +
              ", Id=" + Id +
              ", ID_Marckrecord=" + ID_Marckrecord +
              ", Time=" + Time +
              ", Date=" + Date +
              '}';
   }
}
