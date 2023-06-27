package com.project.scolarite.restcontroller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.Formateur;
import com.project.scolarite.entities.Role;
import com.project.scolarite.repos.FormateurRepository;
import com.project.scolarite.repos.UserRepository;
import com.project.scolarite.services.EmailVerificationService;

@RestController
@RequestMapping("/api/Formateur")
public class FormateurController {
	
	@Autowired
	  UserRepository UserRepository;
	@Autowired
	FormateurRepository FormateurRepository ;
	
	 @Autowired
	    private EmailVerificationService emailVerificationService;
	
	
		@GetMapping("/verify-email")
	    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
	        try {
	            emailVerificationService.verifyEmail(token);
	            
	            return ResponseEntity.ok("<!DOCTYPE html>\n"
	            		+ "<html>\n"
	            		+ "\n"
	            		+ "<head>\n"
	            		+ "    <title></title>\n"
	            		+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
	            		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
	            		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
	            		+ "    <style type=\"text/css\">\n"
	            		+ "        @media screen {\n"
	            		+ "            @font-face {\n"
	            		+ "                font-family: 'Lato';\n"
	            		+ "                font-style: normal;\n"
	            		+ "                font-weight: 400;\n"
	            		+ "                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\n"
	            		+ "            }\n"
	            		+ "\n"
	            		+ "            @font-face {\n"
	            		+ "                font-family: 'Lato';\n"
	            		+ "                font-style: normal;\n"
	            		+ "                font-weight: 700;\n"
	            		+ "                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\n"
	            		+ "            }\n"
	            		+ "\n"
	            		+ "            @font-face {\n"
	            		+ "                font-family: 'Lato';\n"
	            		+ "                font-style: italic;\n"
	            		+ "                font-weight: 400;\n"
	            		+ "                src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\n"
	            		+ "            }\n"
	            		+ "\n"
	            		+ "            @font-face {\n"
	            		+ "                font-family: 'Lato';\n"
	            		+ "                font-style: italic;\n"
	            		+ "                font-weight: 700;\n"
	            		+ "                src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\n"
	            		+ "            }\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        /* CLIENT-SPECIFIC STYLES */\n"
	            		+ "        body,\n"
	            		+ "        table,\n"
	            		+ "        td,\n"
	            		+ "        a {\n"
	            		+ "            -webkit-text-size-adjust: 100%;\n"
	            		+ "            -ms-text-size-adjust: 100%;\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        table,\n"
	            		+ "        td {\n"
	            		+ "            mso-table-lspace: 0pt;\n"
	            		+ "            mso-table-rspace: 0pt;\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        img {\n"
	            		+ "            -ms-interpolation-mode: bicubic;\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        /* RESET STYLES */\n"
	            		+ "        img {\n"
	            		+ "            border: 0;\n"
	            		+ "            height: auto;\n"
	            		+ "            line-height: 100%;\n"
	            		+ "            outline: none;\n"
	            		+ "            text-decoration: none;\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        table {\n"
	            		+ "            border-collapse: collapse !important;\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        body {\n"
	            		+ "            height: 100% !important;\n"
	            		+ "            margin: 0 !important;\n"
	            		+ "            padding: 0 !important;\n"
	            		+ "            width: 100% !important;\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        /* iOS BLUE LINKS */\n"
	            		+ "        a[x-apple-data-detectors] {\n"
	            		+ "            color: inherit !important;\n"
	            		+ "            text-decoration: none !important;\n"
	            		+ "            font-size: inherit !important;\n"
	            		+ "            font-family: inherit !important;\n"
	            		+ "            font-weight: inherit !important;\n"
	            		+ "            line-height: inherit !important;\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        /* MOBILE STYLES */\n"
	            		+ "        @media screen and (max-width:600px) {\n"
	            		+ "            h1 {\n"
	            		+ "                font-size: 32px !important;\n"
	            		+ "                line-height: 32px !important;\n"
	            		+ "            }\n"
	            		+ "        }\n"
	            		+ "\n"
	            		+ "        /* ANDROID CENTER FIX */\n"
	            		+ "        div[style*=\"margin: 16px 0;\"] {\n"
	            		+ "            margin: 0 !important;\n"
	            		+ "        }\n"
	            		+ "    </style>\n"
	            		+ "</head>\n"
	            		+ "\n"
	            		+ "<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\n"
	            		+ "    <!-- HIDDEN PREHEADER TEXT -->\n"
	            		+ "    <div\n"
	            		+ "        style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n"
	            		+ "        Nous sommes ravis de vous avoir ici! Préparez-vous à se connecter dans votre nouveau compte.\n"
	            		+ "    </div>\n"
	            		+ "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
	            		+ "        <!-- LOGO -->\n"
	            		+ "        <tr>\n"
	            		+ "            <td bgcolor=\"#28a745\" align=\"center\">\n"
	            		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n"
	            		+ "                    <tr>\n"
	            		+ "                        <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>\n"
	            		+ "                    </tr>\n"
	            		+ "                </table>\n"
	            		+ "            </td>\n"
	            		+ "        </tr>\n"
	            		+ "        <tr>\n"
	            		+ "            <td bgcolor=\"#28a745\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n"
	            		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n"
	            		+ "                    <tr>\n"
	            		+ "                        <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\"\n"
	            		+ "                            style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\n"
	            		+ "                            <h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">Bienvenue!</h1> <img\n"
	            		+ "                                src=\" https://img.icons8.com/clouds/100/000000/handshake.png\" width=\"125\" height=\"120\"\n"
	            		+ "                                style=\"display: block; border: 0px;\" />\n"
	            		+ "                        </td>\n"
	            		+ "                    </tr>\n"
	            		+ "                </table>\n"
	            		+ "            </td>\n"
	            		+ "        </tr>\n"
	            		+ "        <tr>\n"
	            		+ "            <td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n"
	            		+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n"
	            		+ "                    <tr>\n"
	            		+ "                        <td bgcolor=\"#ffffff\" align=\"left\"\n"
	            		+ "                            style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n"
	            		+ "                            <p style=\"margin: 0;\">Votre compte a été bien vérifier . Appuyez simplement sur le bouton\n"
	            		+ "                                ci-dessous pour se connecter.</p>\n"
	            		+ "                        </td>\n"
	            		+ "                    </tr>\n"
	            		+ "                    <tr>\n"
	            		+ "                        <td bgcolor=\"#ffffff\" align=\"left\">\n"
	            		+ "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
	            		+ "                                <tr>\n"
	            		+ "                                    <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\n"
	            		+ "                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
	            		+ "                                            <tr>\n"
	            		+ "                                                <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#28a745\"><a\n"
	            		+ "                                                        href=\"http://localhost:4200/login\" + getVerificationUrl(user)\"\n"
	            		+ "                                                        target=\"_blank\"\n"
	            		+ "                                                        style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #FFA73B; display: inline-block;\">\n"
	            		+ "                                                        Se connecter </a></td>\n"
	            		+ "                                            </tr>\n"
	            		+ "                                        </table>\n"
	            		+ "                                    </td>\n"
	            		+ "                                </tr>\n"
	            		+ "                            </table>\n"
	            		+ "                        </td>\n"
	            		+ "                    </tr> <!-- COPY -->\n"
	            		+ "\n"
	            		+ "                </table>\n"
	            		+ "            </td>\n"
	            		+ "        </tr>\n"
	            		+ "\n"
	            		+ "        <tr>\n"
	            		+ "\n"
	            		+ "        </tr>\n"
	            		+ "    </table>\n"
	            		+ "</body>\n"
	            		+ "\n"
	            		+ "</html>");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
		
    @PostMapping("/add")
    public Formateur createFormateur(MultipartFile file,
    		               String Specialite, 
                        String telFormateur ,
                             String NomFormateur, 
                              String PrenonFormateur, 
                              
                      String Password,
                    
                            String Email,
                          String AdresseFormateur) throws IOException {
    	Formateur Formateur= new Formateur();
    	Formateur.setNom(NomFormateur);
     long	TelFormateur=Long.valueOf(telFormateur);
     Formateur.setTel(TelFormateur);
  
   Formateur.setPrenom(PrenonFormateur);
   Formateur.setAdresse(AdresseFormateur);
   Formateur.setSpecialite( Specialite);
   Formateur.setFileType(file.getContentType());
   Formateur.setData(file.getBytes());
   Formateur.setCreatedAt(LocalDateTime.now());
   Formateur.setUpdatedAt(LocalDateTime.now());
   
   
   Formateur.setPassword(new BCryptPasswordEncoder().encode( Password ));
   
   Formateur.setRole(Role.FORMATEUR);
   Formateur.setEmail(Email);
   
   emailVerificationService.sendVerificationEmail( Formateur);
	
        return  UserRepository.save(Formateur);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Formateur>> getAllImages() {
        List<Formateur>Formateur =FormateurRepository.findAll();
        return new ResponseEntity<>(Formateur, HttpStatus.OK);
    }
    @GetMapping("/{codeFormateur}")
    public ResponseEntity<Formateur> getFormateurbyId(@PathVariable Long codeDepartement) {
        Optional<Formateur> Formateur = FormateurRepository.findById(codeDepartement);
        if (Formateur.isPresent()) {
            return ResponseEntity.ok(Formateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{codeFormateur}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long codeFormateur,
    		MultipartFile file,
            String Specialite, 
        String telFormateur ,
              String NomFormateur, 
               String PrenonFormateur, 
               String Password,
             String Email,
           String AdresseFormateur
           ) throws IOException {
        Optional<Formateur> optionalFormateur = FormateurRepository.findById(codeFormateur);
        if (optionalFormateur.isPresent()) {
        	Formateur Formateur = optionalFormateur.get();
        	Formateur.setNom(NomFormateur);
           long	TelFormateur=Long.valueOf(telFormateur);
            Formateur.setTel(TelFormateur);
       
         Formateur.setPrenom(PrenonFormateur);
         Formateur.setAdresse(AdresseFormateur);
         Formateur.setSpecialite( Specialite);
        // Formateur.setVerified(true);
         
         if (Password!= null && !Password.isEmpty()) {

             Formateur.setPassword(new BCryptPasswordEncoder().encode( Password ));
             
         }
        
         if (file!=null) {
         Formateur.setFileType(file.getContentType());
         Formateur.setData(file.getBytes());}
         
        // Formateur.setVerified(true);
         Formateur.setCreatedAt(LocalDateTime.now());
         Formateur.setUpdatedAt(LocalDateTime.now());
         
         
         Formateur.setRole(Role.FORMATEUR);
         Formateur.setEmail(Email);
            return ResponseEntity.ok( UserRepository.save(Formateur));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codeFormateur}")
    public ResponseEntity<Void> deletFormateur(@PathVariable Long codeFormateur) {
    	FormateurRepository.deleteById(codeFormateur);
        return ResponseEntity.noContent().build();
    }
	
    
    
    @DeleteMapping("/Archivee/{codeFormateur}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long codeFormateur
    		
           ) throws IOException {
        Optional<Formateur> optionalFormateur = FormateurRepository.findById(codeFormateur);
        if (optionalFormateur.isPresent()) {
        	Formateur Formateur = optionalFormateur.get();
        	Formateur.setArchive(true);
                      return ResponseEntity.ok( UserRepository.save(Formateur));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @DeleteMapping("/desArchivee/{codeFormateur}")
    public ResponseEntity<Formateur> desArchiveeFormateur(@PathVariable  Long codeFormateur
    		
           ) throws IOException {
        Optional<Formateur> optionalFormateur = FormateurRepository.findById(codeFormateur);
        if (optionalFormateur.isPresent()) {
        	Formateur Formateur = optionalFormateur.get();
        	Formateur.setArchive(false);
                      return ResponseEntity.ok( UserRepository.save(Formateur));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
	
	
}
