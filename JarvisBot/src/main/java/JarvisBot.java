import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class JarvisBot extends TelegramLongPollingBot{
    @Override
    public String getBotUsername() {
        // retorna el username del bot
        // Si el username del bot es Jarvis_RD_Bot, esta sera la salida:
        return "Jarvis_RD_Bot";
    }

    @Override
    public String getBotToken() {
        // Retorna el token del bot facilitado por telegram en BotFather
        return "1488421768:AAFETFoxwUcz7f2M39yAEtEDW5LRFEKkJKw";
    }

    @Override

    public void onUpdateReceived(Update update) {

//            System.out.println(update.getMessage().getText());
//            System.out.println(update.getMessage().getFrom().getFirstName() );

        String command=update.getMessage().getText();

        SendMessage message = new SendMessage();

        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();

        if(command.equals("/myname")){
            // Mostramos por consola el nombre del usuario de telegram que utiliza el comando /myname
            //System.out.println(update.getMessage().getFrom().getFirstName());
            // Mostramos por el chat el nombre del usuario de telegram que utiliza el comando /myname
            message.setText(update.getMessage().getFrom().getFirstName());
        }

        if (command.equals("/mylastname")){
            // Mostramos por consola el apellido del usuario de telegram que utiliza el comando /mylastname
            //System.out.println(update.getMessage().getFrom().getLastName());
            // Mostramos por el chat el apellido del usuario de telegram que utiliza el comando /mylastname
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/myfullname")){
            // Mostramos por consola el nombre completo del usuario que utiliza el comando especificado
            //System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            // Mostramos por chat el nombre completo del usuario que utiliza el comando especificado
            message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
        }

        message.setChatId(String.valueOf(chat_id));
        // message.setText(message_text); Muestra el mensaje mismo mensaje que introduce el usuario.


        try {
            execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}
