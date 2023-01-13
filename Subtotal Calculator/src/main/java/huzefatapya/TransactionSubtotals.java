package huzefatapya;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;

public class TransactionSubtotals{

    private ArrayList <Transaction> fileContents;
    private ArrayList <String> categories;
    private ArrayList <Transaction> outputFile;
    private String path = "/Users/huzefatapya/Downloads/Expenses.csv";
    private String outputPath = "/Users/huzefatapya/Desktop/Subtotals.csv";

    private String username = "huz.tap@outlook.com";
    private String password = "Huzefa53";
    private String fromEmail = "huz.tap@outlook.com";
    private String toEmail = "ktapya@yahoo.com";


    public ArrayList <Transaction> readFile(){
        
        fileContents = new ArrayList <Transaction>();
        BufferedReader br = null;
        
        try{

            br = new BufferedReader(new FileReader(path));

            String line = null;

            br.readLine(); //reads the header so it doesn't get stored in array list

            while((line = br.readLine()) != null){
                /*
                 * Split the line at the two commans to create three strings
                 * Parse the third String as a double
                 * Create a new object using those values
                 */
                String[] file = line.split(",", 4);

                double cost = Double.parseDouble(file[2]);

                Transaction transaction = new Transaction(file[0], file[1], cost);
                fileContents.add(transaction);

            }

            br.close();
        } 
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return fileContents;
    }

    public ArrayList <Transaction> getOutputArray(ArrayList <Transaction> fileContents){
        
        categories = new ArrayList <String>();
        outputFile = new ArrayList <Transaction>();

        // iterate through arraylist
        for (Transaction t : fileContents){
            if (categories.indexOf(t.getPurchase()) == -1){
                Transaction transaction = new Transaction (t.getPurchase(), t.getCost());
                outputFile.add(transaction);
                categories.add(t.getPurchase());
            }
            else {
                for (Transaction val: outputFile){
                    if (val.getPurchase().equalsIgnoreCase(t.getPurchase())){
                        Transaction transaction = new Transaction (val.getPurchase(), val.increaseCost(t.getCost()));
                        outputFile.add(transaction);
                        outputFile.remove(val);
                        break;
                    }
                }
            }
        }

        return outputFile;
        

    }

    public void writeFile (ArrayList <Transaction> outputFile) throws IOException{
        
        File file = new File(outputPath);
        Formatter fmt = new Formatter();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            
            //Header
            bufferedWriter.write(String.format("%10s %15s","Purchase","Subtotal"));
            bufferedWriter.newLine();
            
            for (Transaction t: outputFile){
                bufferedWriter.write(String.format("%10s %15s", t.getPurchase(), t.getCost()));
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
        }

        fmt.close();

    }

    public void sendEmail () throws IOException{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.trust", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.debug", "true");
        //properties.put("mail.smptp.ssl.enable", "true");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Subtotals");
            //message.setText("See attached file");

            MimeMultipart mp = new MimeMultipart();

            MimeBodyPart file = new MimeBodyPart();
            file.attachFile(outputPath);

            MimeBodyPart msg = new MimeBodyPart();
            msg.setContent("See attached file", "text/html");
            mp.addBodyPart(msg);
            mp.addBodyPart(file);

            message.setContent(mp);
            
            Transport.send(message);
        }  
        catch (MessagingException e){
            e.printStackTrace();
        }

    }

    
}

