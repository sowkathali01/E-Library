import java.util.*;
import java.io.*;
class student 
{
   ArrayList<String> st=new ArrayList<String>();
   String sname;
   int spass,s_id,lid;
   boolean flag;
   student(String sname,int spass,int s_id,boolean flag)
   {
      this.sname=sname;
      this.spass=spass;
      this.s_id=s_id;
      this.flag=flag;
   }
}
class bookstack
{
   ArrayList<String> a=new ArrayList<String>();
   String bname,bauthor;
   int bcount,bid,bcount2=0;
   boolean flagbook=false;
   bookstack(String bname,String bauthor,int bcount,int bid,boolean flagbook)
   {
       this.bname=bname;
       this.bauthor=bauthor;
       this.bcount=bcount;
       this.bid=bid;
       this.flagbook=flagbook;
   }
}
class sample
{
   static int bid=1000,s_id=2000;
	public static void main(String[] args)throws  Exception
	{
	   Scanner sc=new Scanner(System.in);
	  
        ArrayList<bookstack> book=new ArrayList<bookstack>();
	   ArrayList<student> stud=new ArrayList<student>();
	   int bc=0,m,fi,j;
	   boolean flg=false;
		while(true)
		{
		   System.out.println("----------WELCOME TO T4TEQ LIBRARY----------\n (1).|ADMIN|\n (2).|STUDENT|\n (3).|EXIT|\n");
		   System.out.print("Enter Your Choise:");
         int x=sc.nextInt();
         if(x==1)
         {
            System.out.print("Enter admin name:");
            String aname=sc.next();
            System.out.print("Enter Admin Password:");
            String apass=sc.next();
            if(aname.equals("sowkath")&& apass.equals("1122"))
            {
               while(true)
               {
                  System.out.println("\t\t-----ADMIN-----");
                  System.out.println(" (1). |Add book|\n (2). |view book|\n (3). |view issued book|\n (4). |back|\n (5). |report|\n");
                  m=sc.nextInt();
                  if(m==1)
                  {
                     System.out.print("Enter how May books you want to add:");
                     bc=sc.nextInt();
                     for(int i=0;i<bc;i++)
                     {
                        System.out.print("Enter book name:");
		                  String bname=sc.next();
		                  System.out.printf("Enter book author:");
		                  String bauthor=sc.next();
		                  System.out.print("Enter Count of books:");
		                  int bcount=sc.nextInt();
		                  bid++;
		                  book.add(new bookstack(bname,bauthor,bcount,bid,true));
		              }
		              System.out.println("Books Added successfully...");
		              }
		              else if(m==2)
		              {
		                 System.out.println("book name\tbook author\tbook count\tbook id");
		                 for(bookstack b:book)
		                 {
		                      System.out.println(b.bname+"\t\t"+b.bauthor+"\t\t"+(b.bcount-b.bcount2)+"\t\t"+b.bid);

		                 }
		              }
		              else if(m==3)
		              {
		                  System.out.println("st.name\tst. id\tlend or not");

		                  for(student s:stud)
    	            {
    	                if(s.flag==true)
    	                {
    	                System.out.println(s.sname+"\t"+s.s_id+"\t"+"Yes");
    	                }
    	                else
    	                System.out.println(s.sname+"\t"+s.s_id+"\t"+"No");
    	            }
                     
		              }
		              else if(m==4)
		              {
		                 break;
                    } 
                    else if(m==5)
                    {
                        FileWriter fl=new FileWriter ("Report file.txt");
    	                fl.write(" Book Id\t BookName\t AuherName\t No.of.book avail\t No.of book lend\n");
    	               for(bookstack b:book)
    	                {
    	                    System.out.println("book id\tbk.nme\tbk.authr\tbk.count\tNo.Of.lend");
    	                    System.out.print(b.bid+"\t\t"+b.bname+"\t\t"+b.bauthor+"\t\t"+b.bcount+"\t\t"+b.bcount2);
    	                    fl.write("book id\tbookname\tbookcount\tNo Of book lend");
        	               fl.write(b.bid+"\t\t"+b.bname+"\t\t"+b.bauthor+"\t\t"+b.bcount+"\t\t"+b.bcount2);
        	               System.out.println();
        	               fl.write("\n");
    	                }
    	                fl.close();
                    }
                    
                  }
            }
            else
            {
               System.out.println("Enter correct admin name or password");
            }
         }
         else if(x==2)
         {
            while(true)
            {
                String sname;
                int spass;
               System.out.println("\t\t\t-----STUDENT-----");
               System.out.println(" (1) . |signup|\n (2) . |login|\n (3) . |back|");
               System.out.println("Enter your choise:");
               int sco=sc.nextInt();
               if(sco==1)
               {
                  System.out.print("Enter your name:");
                  sname=sc.next();
                  System.out.print("Enter Your password:");
                  spass=sc.nextInt();
                  System.out.println("Your Id is:"+s_id);
                  stud.add(new student(sname,spass,s_id,false)); 
                  s_id++;
                  
               }
               else if(sco==2)
               {
                   System.out.print("Enter name:");
                   String snme=sc.next();
                   System.out.print("Enter password:");
                  int pw=sc.nextInt();
                  for(student s:stud)
                  {
                     if(s.sname.equals(snme)&&s.spass==pw)
                     {
                         flg=true;
                         while(true)
                         {

                        System.out.println(" (1). |lend book|\n (2). |view book|\n (3). |return book|\n (4). |Back|\n ");
                        int se=sc.nextInt();
                        if(se==1)
                        
                           {
                              if(s.flag==false)
                              {
                                  System.out.print("Enter book id:");
                                  int q=sc.nextInt();
                                  for(bookstack b:book)
                                  {
                                      if(q==b.bid)
                                      {
                                         b.bcount2++;
                                         s.flag=true;
                                         s.lid=q;
                                         
                                      }
                                      
                                  }
                           System.out.println("book lended success fully...");
                        
                               }
                               else
                               {
                                   System.out.println("you already lend book..");
                               }
                        
                            }
                        else if(se==2)
                        {
                           
		                 System.out.println("book name\tbook author\tbook count\tbook id");
		                 for(bookstack b:book)
		                 {
		                    System.out.println(b.bname+"\t\t"+b.bauthor+"\t\t"+(b.bcount-b.bcount2)+"\t\t"+b.bid);
		                 }
                           

                        }
                        else if(se==3)
                        {
                         boolean lnd=false,lnd1=false;
                           if(s.flag==true)
                           {
                               
                               System.out.print("Enter book id:");
                           int o=sc.nextInt();
                           for(bookstack b:book)
                           {
                              if(o==b.bid&&b.bid==s.lid)
                              {
                                  lnd1=true;
                                 b.bcount2--;
                                 s.flag=false;
                                 lnd=true;
                                 System.out.println("book..");

                              }
                             

                           }
                            if(lnd1==false)
                                  System.out.println("your lend book id is wrong..");
                            if(lnd==true)
                           {
                               System.out.println("book returned successfully..");
                           }
                           }
                          
                           else
                           System.out.println("you're not lend any book...");
                    }
                        else if(se==4)
                        {
                    
                           break;
                        }
                        
                     }
                     
                  }

                    
                        
                    
		            }
		            if(flg==false)
		            {
                        System.out.println("wrong pass or id...");
		            }
               }
		         else if(sco==3)
		         {
		            break;
		         }
            }
            }
      else if(x==3)
		         {
		            break;
		         }
		         else
		         {
		            System.out.println("choose corrct destinathion");
	              }
		        
	}
   }

}
