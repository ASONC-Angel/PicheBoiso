import java.util.Scanner;
public class Equipo1{
   public static void main(String[] args){
      
      Scanner read = new Scanner(System.in);
      
      int folios[] = new int[10]; //Change to 70
      String plates[] = new String[10];
      String brands[] = new String[10];
      String models[] = new String[10];
      String colors[] = new String[10];
      float fines[] = new float[10];
      int opc = 0, cont = 0;
      boolean exists;
      
      do{
         System.out.println("Bienvenido Usuario :)");
         System.out.println("1) Alta");
         System.out.println("2) Consulta Individual");
         System.out.println("3) Consulta General");
         System.out.println("4) Modificacion");
         System.out.println("5) Baja");
         System.out.println("6) Finalizar");
         
         System.out.print("Ingrese una opcion [1-6]: ");
         opc = read.nextInt();
         
         switch(opc){
            case 1: 
				exists = true; 
				//while(exists){
					System.out.print("Ingrese el Folio: ");
                    folios[cont] = read.nextInt();
                    read.nextLine();
                    if(cont > 0){
                        for(int i = 0; i < cont; i++)
                           if(folios[cont] == folios[i]){
                              System.out.printf("EL folio %d ya existe, por favor ingrese otro \n", folios[cont]);
                              break;
                            }
                            else{
								System.out.print("Placas: ");
								plates[cont] = read.nextLine();
								System.out.print("Marca: ");
								brands[cont] = read.nextLine();
								System.out.print("Modelo: ");
								models[cont] = read.nextLine();
								System.out.print("Color: ");
								colors[cont] = read.nextLine();
								System.out.print("Costo de la multa: ");
								fines[cont] = read.nextFloat();
								
								cont++; 
								exists = false;
								break;
                            }
                    }
                    else{
                        System.out.print("Placas: ");
                        plates[cont] = read.nextLine();
                        System.out.print("Marca: ");
                        brands[cont] = read.nextLine();
                        System.out.print("Modelo: ");
                        models[cont] = read.nextLine();
                        System.out.print("Color: ");
                        colors[cont] = read.nextLine();
                        System.out.print("Costo de la multa: ");
                        fines[cont] = read.nextFloat();
                        
						cont++;
                        exists = false;
                    }
                //}
            break;
            case 2: 
				exists = true;
                //while(exists){
					if(cont > 0){
						System.out.print("Ingresa el Folio: ");
						int folio = read.nextInt();
						
						if(folio < 100 && folio > 0 ){
							for(int i=0; i<cont; i++)
								if(folio == folios[i]){
									System.out.printf("El Folio %d corresponde A: \n", folio);
									System.out.printf("Folio: %d\n", folios[i]);
									System.out.printf("Placas: %s\n", plates[i]);
									System.out.printf("Marca: %s\n", brands[i]);
									System.out.printf("Modelo: %s\n", models[i]);
									System.out.printf("Color: %s\n", colors[i]);
									exists = false;
									break;
								}
							if(exists){
								System.out.printf("El folio %d no se encuentra registrado\n", folio);
								//exists = false;
							}
						}
						else{
							System.out.println("El folio ingresado esta fuera de rango");
							//break;	
						}
						
					}
					else{
						  System.out.println("No se encuentra infomacion registrada");
						  //exists = false;
					}
				//}
            break; 	
            case 3: 
				exists = true;
				if(cont > 0){
					for(int i=0; i<folios.length-1; i++){
						for(int j=i; j<folios.length; j++){
							int auxFolios = folios[i];
							folios[i] = folios[j];
							folios[j] = auxFolios;
							
							String auxPlates = plates[i];
							plates[i] = plates[j];
							plates[j] = auxPlates;
							
							String auxbrands = brands[i];
							brands[i] = brands[j];
							brands[j] = auxbrands;
							
							String auxModels = models[i];
							models[i] = models[j];
							models[j] = auxModels;
							
							String auxColors = colors[i];
							colors[i] = colors[j];
							colors[j] = auxColors;
						}
					}
					System.out.println("  Folio     Placas    Modelo    Multa");
					System.out.println("--------- --------- --------- ---------");
					for(int x=0; x<cont; x++){
						//System.out.println("--------- --------- --------- ---------");
						System.out.printf("%d        %s        %s                %.2f\n", folios[x], plates[x], models[x], fines[x]);
					}
				}
				else
					System.out.println("No se encuentra infomacion registrada");
			break;
            case 4: System.out.println("Entraste a Modif"); break;
            case 5: 
				exists = true;
				int indice = 0;
				if(cont > 0){
					
					System.out.print("Ingresa el Folio: ");
					int folio = read.nextInt(); 
					
					if(folio < 100 && folio > 0){
						for(int i=0; i<cont; i++)
							if(folios[i] == folio){
								indice = i;
								exists = false;
								break;
							}
						if(exists == false){
							System.out.println("Los datos registrados son los siguientes: ");
							System.out.printf("Folio: %d\n", folios[indice]);
							System.out.printf("Placas: %s\n", plates[indice]);
							System.out.printf("Marca: %s\n", brands[indice]);
							System.out.printf("Modelo: %s\n", models[indice]);
							System.out.printf("Color: %s\n", colors[indice]);
							
							System.out.printf("Esta seguro que quieres eliminar la infomacion? ");
							read.nextLine();
							String resp = read.nextLine();
							if(resp.toUpperCase().equals("SI")){
								for(int j=indice; j<folios.length-1; j++){
									folios[j] = folios[j+1];
									plates[j] = plates[j+1];
									brands[j] = brands[j+1];
									models[j] = models[j+1];
									colors[j] = colors[j+1];
								}
							System.out.println("Informaicion Eliminada con exito");	
							}
							else 
								break;
						}
						else
							System.out.println("El folio no se encuentra registrado");
					}
					else
						System.out.println("El folio ingresado esta fuera de rango");
				}
				else 
					System.out.println("No se encuentra infomacion registrada");
			break;
            case 6: 
				
			break;
            default: System.out.println("Opcion No valida :C"); ;
         }   
      
      }while(opc != 6);      
      
   }
}