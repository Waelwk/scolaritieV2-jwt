package com.project.scolarite.restcontroller;

import java.io.UnsupportedEncodingException;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.scolarite.entities.User;
import com.project.scolarite.entities.Utility;
import com.project.scolarite.repos.UserRepository;
import com.project.scolarite.services.UserServices;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;


@RestController
@RequestMapping("/api/Password")

public class ForgotPasswordController {
	@Autowired
    private UserRepository userRepos;
	@Autowired
    private JavaMailSender mailSender;
	
	 
    @Autowired
    private UserServices customerService;
     
    @GetMapping("/forgot_password")
    
    public String showForgotPasswordForm() {
    	
        return "<div>\n"
        		+ "    <h2>Forgot Password</h2>\n"
        		+ "</div>\n"
        		+ "     \n"
        		+ "<div th:if=\"${error != null}\">\n"
        		+ "    <p class=\"text-danger\">[[${error}]]</p>\n"
        		+ "</div>\n"
        		+ "<div th:if=\"${message != null}\">\n"
        		+ "    <p class=\"text-warning\">[[${message}]]</p>\n"
        		+ "</div>\n"
        		+ "         \n"
        		+ "<form th:action=\"@{/forgot_password}\" method=\"post\" style=\"max-width: 420px; margin: 0 auto;\">\n"
        		+ "<div class=\"border border-secondary rounded p-3\">\n"
        		+ "    <div>\n"
        		+ "        <p>We will be sending a reset password link to your email.</p>\n"
        		+ "    </div>\n"
        		+ "    <div>\n"
        		+ "        <p>\n"
        		+ "            <input type=\"email\" name=\"email\" class=\"form-control\" placeholder=\"Enter your e-mail\" required autofocus/>\n"
        		+ "        </p>         \n"
        		+ "        <p class=\"text-center\">\n"
        		+ "            <input type=\"submit\" value=\"Send\" class=\"btn btn-primary\" />\n"
        		+ "        </p>\n"
        		+ "    </div>\n"
        		+ "</div>\n"
        		+ "</form>";
        		}
 
    @PostMapping("/forgot_password")
    public ResponseEntity<?> processForgotPassword(HttpServletRequest request) throws AccountNotFoundException {
        String email = request.getParameter("email");
        String token = RandomString.make(30);
         boolean emailExist = userRepos.findEmail(email) != null;

        if(emailExist) {
            customerService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/api/Password/reset_password?token=" + token;
            try {
				sendEmail(email, resetPasswordLink);
			} catch (UnsupportedEncodingException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String message = "We have sent a reset password link to your email. Please check.";
            return ResponseEntity.ok(message);
        } else  {
            String error = "Error while sending email";
            return ResponseEntity.notFound().build();
        }
    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();              
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom("contact@shopme.com", "Shopme Support");
        helper.setTo(recipientEmail);
         
        String subject = "Here's the link to reset your password";
         
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
         
        helper.setSubject(subject);
         
        helper.setText(content, true);
         
        mailSender.send(message);
    }
     

    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
   User customer = customerService.getByResetPasswordToken(token);
        model.addAttribute("token", token);
         
        if (customer == null) {
            model.addAttribute("message", "Invalid Token");
            return "invalid token ";
        }
         
        return "<style>.mainDiv {\n"
        		+ "    display: flex;\n"
        		+ "    min-height: 100%;\n"
        		+ "    align-items: center;\n"
        		+ "    justify-content: center;\n"
        		+ "    background-color: #f9f9f9;\n"
        		+ "    font-family: 'Open Sans', sans-serif;\n"
        		+ "  }\n"
        		+ " .cardStyle {\n"
        		+ "    width: 500px;\n"
        		+ "    border-color: white;\n"
        		+ "    background: #fff;\n"
        		+ "    padding: 36px 0;\n"
        		+ "    border-radius: 4px;\n"
        		+ "    margin: 30px 0;\n"
        		+ "    box-shadow: 0px 0 2px 0 rgba(0,0,0,0.25);\n"
        		+ "  }\n"
        		+ "#signupLogo {\n"
        		+ "  max-height: 100px;\n"
        		+ "  margin: auto;\n"
        		+ "  display: flex;\n"
        		+ "  flex-direction: column;\n"
        		+ "}\n"
        		+ ".formTitle{\n"
        		+ "  font-weight: 600;\n"
        		+ "  margin-top: 20px;\n"
        		+ "  color: #2F2D3B;\n"
        		+ "  text-align: center;\n"
        		+ "}\n"
        		+ ".inputLabel {\n"
        		+ "  font-size: 12px;\n"
        		+ "  color: #555;\n"
        		+ "  margin-bottom: 6px;\n"
        		+ "  margin-top: 24px;\n"
        		+ "}\n"
        		+ "  .inputDiv {\n"
        		+ "    width: 70%;\n"
        		+ "    display: flex;\n"
        		+ "    flex-direction: column;\n"
        		+ "    margin: auto;\n"
        		+ "  }\n"
        		+ "input {\n"
        		+ "  height: 40px;\n"
        		+ "  font-size: 16px;\n"
        		+ "  border-radius: 4px;\n"
        		+ "  border: none;\n"
        		+ "  border: solid 1px #ccc;\n"
        		+ "  padding: 0 11px;\n"
        		+ "}\n"
        		+ "input:disabled {\n"
        		+ "  cursor: not-allowed;\n"
        		+ "  border: solid 1px #eee;\n"
        		+ "}\n"
        		+ ".buttonWrapper {\n"
        		+ "  margin-top: 40px;\n"
        		+ "}\n"
        		+ "  .submitButton {\n"
        		+ "    width: 70%;\n"
        		+ "    height: 40px;\n"
        		+ "    margin: auto;\n"
        		+ "    display: block;\n"
        		+ "    color: #fff;\n"
        		+ "    background-color: #065492;\n"
        		+ "    border-color: #065492;\n"
        		+ "    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.12);\n"
        		+ "    box-shadow: 0 2px 0 rgba(0, 0, 0, 0.035);\n"
        		+ "    border-radius: 4px;\n"
        		+ "    font-size: 14px;\n"
        		+ "    cursor: pointer;\n"
        		+ "  }\n"
        		+ ".submitButton:disabled,\n"
        		+ "button[disabled] {\n"
        		+ "  border: 1px solid #cccccc;\n"
        		+ "  background-color: #cccccc;\n"
        		+ "  color: #666666;\n"
        		+ "}\n"
        		+ "\n"
        		+ "#loader {\n"
        		+ "  position: absolute;\n"
        		+ "  z-index: 1;\n"
        		+ "  margin: -2px 0 0 10px;\n"
        		+ "  border: 4px solid #f3f3f3;\n"
        		+ "  border-radius: 50%;\n"
        		+ "  border-top: 4px solid #666666;\n"
        		+ "  width: 14px;\n"
        		+ "  height: 14px;\n"
        		+ "  -webkit-animation: spin 2s linear infinite;\n"
        		+ "  animation: spin 2s linear infinite;\n"
        		+ "}\n"
        		+ "\n"
        		+ "@keyframes spin {\n"
        		+ "    0% { transform: rotate(0deg); }\n"
        		+ "    100% { transform: rotate(360deg); }\n"
        		+ "}</style>\n"
        		+ "\n"
        		+ "<div class=\"mainDiv\">\n"
        		+ "  <div class=\"cardStyle\">\n"
        		+ "<form th:action=\"@{/reset_password}\" method=\"post\" style=\"max-width: 350px; margin: 0 auto;\">\n"
        		+ "      \n"
        		+ "      <img src=\"\" id=\"signupLogo\"/>\n"
        		+ "      \n"
        		+ "      <h2 class=\"formTitle\">\n"
        		+ "    Changer votre mot de passe \n"
        		+ "      </h2>\n"
        		+ "      \n"
        		+ "    <div class=\"inputDiv\">\n"
        		+ "      <label class=\"inputLabel\" for=\"password\">Nouveau mot de passe </label>\n"
        		+ "      <input type=\"password\" id=\"password\" name=\"password\" required>\n"
        		+ "    </div>\n"
        		+ "      \n"
        		+ "    <div class=\"inputDiv\">\n"
        		+ "      <label class=\"inputLabel\" for=\"confirmPassword\">Confirmer mot de passe</label>\n"
        		+ "      <input type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\">\n"
        		+ "    </div>\n"
        		+ "    \n"
        		+ "    <div class=\"buttonWrapper\">\n"
        		+ "      <button type=\"submit\" id=\"submitButton\" onclick=\"validateSignupForm()\" class=\"submitButton pure-button pure-button-primary\">\n"
        		+ "        <span>Continuer</span>\n"
        		+ "        <span id=\"loader\"></span>\n"
        		+ "      </button>\n"
        		+ "    </div>\n"
        		+ "      \n"
        		+ "  </form>\n"
        		+ "  </div>\n"
        		+ "</div>\n"
        		+ "<script>var password = document.getElementById(\"password\")\n"
        		+ "  , confirm_password = document.getElementById(\"confirmPassword\");\n"
        		+ "\n"
        		+ "document.getElementById('signupLogo').src = \"https://cdn-icons-png.flaticon.com/512/6195/6195700.png\";\n"
        		+ "enableSubmitButton();\n"
        		+ "\n"
        		+ "function validatePassword() {\n"
        		+ "  if(password.value != confirm_password.value) {\n"
        		+ "    confirm_password.setCustomValidity(\"Passwords Don't Match\");\n"
        		+ "    return false;\n"
        		+ "  } else {\n"
        		+ "    confirm_password.setCustomValidity('');\n"
        		+ "    return true;\n"
        		+ "  }\n"
        		+ "}\n"
        		+ "\n"
        		+ "password.onchange = validatePassword;\n"
        		+ "confirm_password.onkeyup = validatePassword;\n"
        		+ "\n"
        		+ "function enableSubmitButton() {\n"
        		+ "  document.getElementById('submitButton').disabled = false;\n"
        		+ "  document.getElementById('loader').style.display = 'none';\n"
        		+ "}\n"
        		+ "\n"
        		+ "function disableSubmitButton() {\n"
        		+ "  document.getElementById('submitButton').disabled = true;\n"
        		+ "  document.getElementById('loader').style.display = 'unset';\n"
        		+ "}\n"
        		+ "\n"
        		+ "function validateSignupForm() {\n"
        		+ "  var form = document.getElementById('signupForm');\n"
        		+ "  \n"
        		+ "  for(var i=0; i < form.elements.length; i++){\n"
        		+ "      if(form.elements[i].value === '' && form.elements[i].hasAttribute('required')){\n"
        		+ "        console.log('There are some required fields!');\n"
        		+ "        return false;\n"
        		+ "      }\n"
        		+ "    }\n"
        		+ "  \n"
        		+ "  if (!validatePassword()) {\n"
        		+ "    return false;\n"
        		+ "  }\n"
        		+ "  \n"
        		+ "  onSignup();\n"
        		+ "}\n"
        		+ "\n"
        		+ "function onSignup() {\n"
        		+ "  var xhttp = new XMLHttpRequest();\n"
        		+ "  xhttp.onreadystatechange = function() {\n"
        		+ "    \n"
        		+ "    disableSubmitButton();\n"
        		+ "    \n"
        		+ "    if (this.readyState == 4 && this.status == 200) {\n"
        		+ "      enableSubmitButton();\n"
        		+ "    }\n"
        		+ "    else {\n"
        		+ "      console.log('AJAX call failed!');\n"
        		+ "      setTimeout(function(){\n"
        		+ "        enableSubmitButton();\n"
        		+ "      }, 1000);\n"
        		+ "    }\n"
        		+ "    \n"
        		+ "  };\n"
        		+ "  \n"
        		+ "  xhttp.open(\"GET\", \"ajax_info.txt\", true);\n"
        		+ "  xhttp.send();\n"
        		+ "}</script>";
    }
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
         
 User customer = customerService.getByResetPasswordToken(token);
        model.addAttribute("title", "Reset your password");
         
        if (customer == null) {
            model.addAttribute("message", "Invalid Token");
            return "Invalid Token";
        } else {           
            customerService.updatePassword(customer, password);
             
            model.addAttribute("message", "You have successfully changed your password.");
        }
         
        return "<!DOCTYPE html>\n"
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
        		+ "                            <p style=\"margin: 0;\">Votre mot de pass  a été bien modifier . Appuyez simplement sur le bouton\n"
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
        		+ "</html>";
    }
}
	
	

