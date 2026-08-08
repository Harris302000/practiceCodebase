package com.user.thread;
import java.util.Base64;

public class WorkerTask implements Runnable {

    private PoolingUtility utility;

    public WorkerTask(PoolingUtility utility) {

        this.utility = utility;

    }

    @Override
    public void run() {

        while (true) {

            Document document = utility.fetchDocument();

            if (document == null) {

                try {

                    System.out.println(Thread.currentThread().getName()
                            + " No Pending Records");

                    Thread.sleep(5000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                continue;

            }

            System.out.println("Uploading the document");
            uploadDocument(document);

        }

    }

    private void uploadDocument(Document document) {

        try {

            System.out.println(Thread.currentThread().getName()
                    + " Processing the document to upload"
                    + document.getId());

            // Base64 -> byte[]
            byte[] file =
                    decode(document.getBase64());

            // Upload to OmniDocs
            String docIndex =
                    upload(file);



            System.out.println(
                    Thread.currentThread().getName()
                    + " Uploaded the document"
                    + document.getId()
            );

        } catch (Exception e) {

            System.out.println("Upload Failed");

        }

    }
    
    public static byte[] decode(String base64) {

    	System.out.println("Decoding'");
        return Base64.getDecoder().decode(base64);

    }
    
    public static String upload(byte[] file) {
    	System.out.println("Uploading to OD'");
        /*
         * OmniDocs API Call
         */

        return "DOC123456";

    }

}