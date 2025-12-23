import java.util.*;

public class encryptProtein {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    boolean running = true;
    while (running){
        System.out.println("Input what you would like to encrypt or decrypt or q to quit: ");
        String plainText = input.nextLine();
        if (!plainText.equalsIgnoreCase("q")){
            System.out.println("Would you like to encrypt(Input E) or decrypt(Input D)?");
            String action = input.nextLine();
            if (action.equalsIgnoreCase("E")){
                System.out.println(encrypt(plainText));
            } else{
                decrypt(plainText);
            }
        } else {
            running = false;
        }
    }
  }
  public static String toBinary(String fst){
      String fstEncrypt = "";
      int num = 0;
      while (num < fst.length()){
          if (fst.substring(num, num + 1).equalsIgnoreCase("A")){
              fstEncrypt+="AAAAAA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("B")){
              fstEncrypt+="AAAAAT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("C")){
              fstEncrypt+="AAAATA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("D")){
              fstEncrypt+="AAAATT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("E")){
              fstEncrypt+="AAATAA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("F")){
              fstEncrypt+="AAATAT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("G")){
              fstEncrypt+="AAATTA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("H")){
              fstEncrypt+="AAATTT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("I") || fst.substring(num, num + 1).equalsIgnoreCase("J")){
              fstEncrypt+="AATAAA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("K")){
              fstEncrypt+="AATAAT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("L")){
              fstEncrypt+="AATATA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("M")){
              fstEncrypt+="AATATT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("N")){
              fstEncrypt+="AATTAA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("O")){
              fstEncrypt+="AATTAT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("P")){
              fstEncrypt+="AATTTA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("Q")){
              fstEncrypt+="AATTTT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("R")){
              fstEncrypt+="ATAAAA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("S")){
              fstEncrypt+="ATAAAT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("T")){
              fstEncrypt+="ATAATA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("U") || fst.substring(num, num + 1).equalsIgnoreCase("V")){
              fstEncrypt+="ATAATT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("W")){
              fstEncrypt+="ATATAA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("X")){
              fstEncrypt+="ATATAT";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("Y")){
              fstEncrypt+="ATATTA";
          } else if (fst.substring(num, num + 1).equalsIgnoreCase("Z")){
              fstEncrypt+="ATATTT";
          }
          num+=1;
      }
      return fstEncrypt;
  }
  public static String toDNA(String scd){
      String scdEncrypt = "";
      int num = 0;
      List<String> aRep = List.of("A", "G");
      List<String> tRep = List.of("T", "C");
      Random rand = new Random();
      while (num < scd.length()){
          if (scd.substring(num, num + 1).equalsIgnoreCase("A")){
              scdEncrypt+= aRep.get(rand.nextInt(aRep.size()));
          } else{
              scdEncrypt+= tRep.get(rand.nextInt(tRep.size()));
          }
          num+=1;
      }
      return scdEncrypt;
  }
  public static String toRNA(String trd){
      String trdEncrypt = "";
      int num = 0;
      while (num < trd.length()){
          if (trd.substring(num, num + 1).equalsIgnoreCase("A")){
              trdEncrypt+= "U";
          } else if (trd.substring(num, num + 1).equalsIgnoreCase("T")){
              trdEncrypt+= "A";
          } else if (trd.substring(num, num + 1).equalsIgnoreCase("C")){
              trdEncrypt+= "G";
          } else if (trd.substring(num, num + 1).equalsIgnoreCase("G")){
              trdEncrypt+= "C";
          }
          num+=1;
      }
      return trdEncrypt;
  }
  public static String toProtein(String frt){
      int num = 0;
      String frtEncrypt = "";
      while (num < frt.length()){
          if (frt.substring(num, num + 1).equals("U")){
              if (frt.substring(num + 1, num + 2).equals("U")){
                 if (frt.substring(num + 2, num + 3).equals("U") || frt.substring(num + 2, num + 3).equals("C")){
                    frtEncrypt+="Phe";
                  } else {
                    frtEncrypt+="Leu";
                  } 
              } else if (frt.substring(num + 1, num + 2).equals("C")){
                  frtEncrypt+="Ser";
              } else if (frt.substring(num + 1, num + 2).equals("A")){
                  if (frt.substring(num + 2, num + 3).equals("A") || frt.substring(num + 2, num + 3).equals("G")){
                      frtEncrypt+="STOP";
                  } else{
                      frtEncrypt+="Tyr";
                  }
              } else{
                  if (frt.substring(num + 2, num + 3).equals("U") || frt.substring(num + 2, num + 3).equals("C")){
                      frtEncrypt+="Cys";
                  } else if (frt.substring(num + 2, num + 3).equals("A")){
                      frtEncrypt+="STOP";
                  } else{
                      frtEncrypt+="Trp";
                  }
              }
          } else if (frt.substring(num, num + 1).equals("C")){
              if (frt.substring(num + 1, num + 2).equals("U")){
                  frtEncrypt+="Leu";
              } else if (frt.substring(num + 1, num + 2).equals("C")){
                  frtEncrypt+="Pro";
              } else if (frt.substring(num + 1, num + 2).equals("A")){
                  if (frt.substring(num + 2, num + 3).equals("U") || frt.substring(num + 2, num + 3).equals("C")){
                      frtEncrypt+="His";
                  } else {
                      frtEncrypt+="Gln";
                  }
              } else {
                  frtEncrypt+="Arg";
              }
          } else if (frt.substring(num, num + 1).equals("A")){
              if (frt.substring(num + 1, num + 2).equals("U")){
                  if(frt.substring(num + 2, num + 3).equals("G")){
                      frtEncrypt+="START";
                  } else{
                      frtEncrypt+="Ile";
                  }
              } else if (frt.substring(num + 1, num + 2).equals("C")){
                  frtEncrypt+="Thr";
              } else if (frt.substring(num + 1, num + 2).equals("A")){
                  if (frt.substring(num + 2, num + 3).equals("U") || frt.substring(num + 2, num + 3).equals("C")){
                      frtEncrypt+="Asn";
                  } else {
                      frtEncrypt+="Lys";
                  }
              } else {
                  if (frt.substring(num + 2, num + 3).equals("U") || frt.substring(num + 2, num + 3).equals("C")){
                      frtEncrypt+="Ser";
                  } else {
                      frtEncrypt+="Arg";
                  }
              }
              
          } else {
              if (frt.substring(num + 1, num + 2).equals("U")){
                  frtEncrypt+="Val";
              } else if (frt.substring(num + 1, num + 2).equals("C")){
                  frtEncrypt+="Ala";
              } else if(frt.substring(num + 1, num + 2).equals("A")){
                  if (frt.substring(num + 2, num + 3).equals("U") || frt.substring(num + 2, num + 3).equals("C")){
                      frtEncrypt+="Asp";
                  } else {
                      frtEncrypt+="Glu";
                  }
              } else{
                  frtEncrypt+="Gly";
              }
          }
          num+=3;
          frtEncrypt+="-";
      }
      return frtEncrypt;
  }
  public static String encrypt (String code) {
    String fstStep = toBinary(code);
    String scdStep = toDNA(fstStep);
    String trdStep = toRNA(scdStep);
    String frtStep = toProtein(trdStep);
    return frtStep;
  }
  public static String ridDash(String fst2){
    int num = 0;
    String fstDe = "";
    while (num < fst2.length()){
        if (!fst2.substring(num, num + 1).equals("-")){
            fstDe+=fst2.substring(num,num + 1);
        }
        num+=1;
    }
    return fstDe;
  }
  public static void fromProtein(String scd2){
    int num = 0;
    ArrayList<String> opt1 = new ArrayList<String>();
    ArrayList<String> opt2 = new ArrayList<String>();
    ArrayList<String> opt3 = new ArrayList<String>();
    while (num < scd2.length()){
        if (scd2.substring(num, num + 3).equals("Phe")){
            opt1.add("AAA");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Leu")){
            opt1.add("AAT");
            opt2.add("AAA");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Ile")){
            opt1.add("TAA");
            opt2.add("TAT");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("START")){
            opt1.add("TAT");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Val")){
            opt1.add("TAA");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Tyr")){
            opt1.add("ATA");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("STOP")){
            opt1.add("ATT");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("His")){
            opt1.add("ATA");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Gln")){
            opt1.add("ATT");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Asn")){
            opt1.add("TTA");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Lys")){
            opt1.add("TTT");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Asp")){
            opt1.add("TTA");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Glu")){
            opt1.add("TTT");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Ser")){
            opt1.add("AAT");
            opt2.add("AAA");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Pro")){
            opt1.add("AAT");
            opt2.add("AAA");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Thr")){
            opt1.add("TAT");
            opt2.add("TAA");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Ala")){
            opt1.add("TAT");
            opt2.add("TAA");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Cys")){
            opt1.add("ATA");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Trp")){
            opt1.add("ATT");
            opt2.add("0");
            opt3.add("0");
        } else if (scd2.substring(num, num + 3).equals("Arg")){
            opt1.add("ATA");
            opt2.add("ATT");
            opt3.add("TTT");
        }
        num+=3;
    }
    System.out.println(opt1);
    System.out.println(opt2);
    System.out.println(opt3);
    ArrayList<ArrayList<String>> optList = new ArrayList<ArrayList<String>>();
    optList.add(opt1);
    optList.add(opt2);
    optList.add(opt3);
    num = 0;
    ArrayList<String> toBinary = new ArrayList<String>();
    int num2 = 0;
    
    while (num < optList.size()){
        String tempString = "";
        num2 = 0;
        while(num2 < optList.get(num).size()){
            if (!String.valueOf(optList.get(num).get(num2)).equals("0")){
                tempString+=optList.get(num).get(num2);
            } else {
                tempString+=optList.get(0).get(num2);
            }
            num2+=1;
        }
        toBinary.add(tempString);
        num+=1;
    }
    
    
    num = 0;
    System.out.println(toBinary);
    ArrayList<String> fromBinary = new ArrayList<String>();
    while (num < toBinary.size()){
        num2 = 0;
        String tempString = "";
        while (num2 < toBinary.get(num).length()){
            if (toBinary.get(num).substring(num2, num2 + 6).equals("AAAAAA")){
                tempString+="A";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AAAAAT"))) {
                tempString+="B";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AAAATA"))) {
                tempString+="C";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AAAATT"))) {
                tempString+="D";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AAATAA"))) {
                tempString+="E";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AAATAT"))) {
                tempString+="F";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AAATTA"))) {
                tempString+="G";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AAATTT"))) {
                tempString+="H";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATAAA"))) {
                tempString+="I/J";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATAAT"))) {
                tempString+="K";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATATA"))) {
                tempString+="L";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATATT"))) {
                tempString+="M";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATTAA"))) {
                tempString+="N";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATTAT"))) {
                tempString+="O";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATTTA"))) {
                tempString+="P";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("AATTTT"))) {
                tempString+="Q";
            } else if ((toBinary.get(num).substring(num2, num2 + 6).equals("ATAAAA"))) {
                tempString+="R";
            }  else if ((toBinary.get(num).substring(num2, num2 + 6).equals("ATAAAT"))) {
                tempString+="S";
            }  else if ((toBinary.get(num).substring(num2, num2 + 6).equals("ATAATA"))) {
                tempString+="T";
            }  else if ((toBinary.get(num).substring(num2, num2 + 6).equals("ATAATT"))) {
                tempString+="U/V";
            }  else if ((toBinary.get(num).substring(num2, num2 + 6).equals("ATATAA"))) {
                tempString+="W";
            }  else if ((toBinary.get(num).substring(num2, num2 + 6).equals("ATATAT"))) {
                tempString+="X";
            }  else if ((toBinary.get(num).substring(num2, num2 + 6).equals("ATATTA"))) {
                tempString+="Y";
            }  else {
                tempString+="Z";
            }

            num2+=6;
        }
        fromBinary.add(tempString);
        num+=1;
    }
    System.out.println(fromBinary);
    num = 0;
    num2 = 0;
    ArrayList<String> toPossible = new ArrayList<String>();
    while (num < fromBinary.get(0).length()){
        String tempString = "";
        while (num2 < fromBinary.get(0).length()){
            tempString += fromBinary.get(num2).substring(num, num+1);
            num2+=1;
        }//I have a list of strings I want to like show all of the combinations where the
        //indexes are the same but strings are diff idk if that makes sense
        toPossible.add(tempString);
        num+=1;
    }
    num = 0;
    num2 = 0;
    while (num < toPossible.size()){
        String tempString = "";
        while (num2 < toPossible.get(0).length()){
            
    }
    System.out.println(tempString);
    }
  }
  public static void decrypt(String ciphertext){
    String cleanText = ridDash(ciphertext);
    fromProtein(cleanText);
  }
}