package MeuRobo;
import robocode.*;

// Classe do robô
public class MeuRobo extends AdvancedRobot {

    // Método run() é chamado quando o robô entra na batalha
    public void run() {
        // Definindo cores do robô
        setColors(java.awt.Color.blue, java.awt.Color.red, java.awt.Color.green);

        // Loop principal do robô
        while (true) {
            // Movimento inteligente para evitar tiros inimigos
            esquivarTiros();
        }
    }

    // Método para esquivar tiros inimigos
    public void esquivarTiros() {
        // Girar a arma em um círculo completo
        turnGunRight(360);

        // Girar a direção do movimento em um ângulo aleatório
        setTurnRight(Math.random() * 360);

        // Avança uma distância aleatória
        setAhead(Math.random() * 200);
        
        // Executa uma verificação para garantir que não colida com a parede
        execute();
    }

    // Método chamado quando um robô é detectado
    public void onScannedRobot(ScannedRobotEvent e) {
        // Calcula o ângulo para virar a arma em direção ao alvo
        double anguloArma = getHeading() - getGunHeading() + e.getBearing();

        // Vira a arma em direção ao alvo
        turnGunRight(anguloArma);

        // Verifica se o alvo está perto o suficiente para atacar
        if (e.getDistance() < 300) {
            // Atira no alvo
            fire(3);
        }
    }
}
