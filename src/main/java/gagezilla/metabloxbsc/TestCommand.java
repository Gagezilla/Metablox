package gagezilla.metabloxbsc;

import gagezilla.metabloxbsc.contracts.ERC20;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigDecimal;

import static gagezilla.metabloxbsc.MetabloxBSC.*;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        String luisAddress = "0xEE0Af8B4d8b5135b4e11c08Bd4Ee18E74D9E7c84";

        BigDecimal luisBal = getBalance(luisAddress);

        if (luisBal != null) {
            sender.sendMessage("Luis has §b" + luisBal.toString() + "§r " + getSymbol());
        }
        else {
            sender.sendMessage("Luis has §b0§r PolkaCity");
        }

//        try {
//            EthGetBalance ethBalance = web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
//            BigDecimal balance = new BigDecimal(ethBalance.getBalance(), 18);
//            sender.sendMessage("You have §c" + balance + "§f BNB");
//            System.out.println("You have " + balance + " BNB");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return true;
    }
}
