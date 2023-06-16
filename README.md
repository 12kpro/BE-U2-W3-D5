Il pattern Observer viene utilizzato per gestire la comunicazione tra la sonda (SmokeSensorr) e il processo di controllo (ControlProcess).
La classe SmokeSensorr rappresenta la sonda e mantiene una lista di osservatori (observers) a cui notifica i cambiamenti del livello di fumo (smokeLevel).
La classe ControlProcess implementa l'interfaccia Observer e viene notificata quando il livello di fumo supera il valore di soglia (5 in questo caso).
Quando ciò accade, il processo di controllo invia un allarme al centro di controllo tramite il proxy (ControlCenterProxy).

Il pattern Proxy viene utilizzato per gestire la comunicazione tra il processo di controllo e il centro di controllo.
La classe ControlCenterProxy implementa l'interfaccia ControlCenter e invia l'allarme al centro di controllo.

La classe ControlCenterImpl rappresenta il centro di controllo e si occupa di notificare il personale competente del pericolo.

Infine, il pattern Factory viene utilizzato per creare le istanze delle classi necessarie per l'implementazione del sistema.

In questo caso, viene utilizzato per creare le istanze della classe SmokeSensor.
