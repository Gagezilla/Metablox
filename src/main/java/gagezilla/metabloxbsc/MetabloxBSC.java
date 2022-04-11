package gagezilla.metabloxbsc;

import gagezilla.metabloxbsc.contracts.ERC20;
import org.bukkit.plugin.java.JavaPlugin;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigDecimal;

public final class MetabloxBSC extends JavaPlugin {
    private static final String polkaCityAddy = "0x6ae9701b9c423f40d54556c9a443409d79ce170a";

    public static Web3j web3 = Web3j.build(new HttpService("https://bsc-dataseed.binance.org/"));

    public static ERC20 contract;

    static {
        try {
            contract = ERC20.load(polkaCityAddy, web3, Credentials.create(Keys.createEcKeyPair()), new DefaultGasProvider());
        } catch (Exception ignored) { }
    }

    public static BigDecimal getBalance(String address) {
        try { return new BigDecimal(contract.balanceOf(address).send(), 18); }
        catch (Exception e) { return null; }
    }

    public static String getSymbol() {
        try { return contract.symbol().send(); }
        catch (Exception e) { return null; }
    }

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(new TestCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
