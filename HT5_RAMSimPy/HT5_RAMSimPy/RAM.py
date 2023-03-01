# Autores: Marcela Cordon, Diego Duarte y Sofia Garcia 
# 28/02/2023
# Objetivo: Simulacion de una memoria RAM 

import simpy
import random
import statistics

# Variables
RANDOM_SEED = 42
INTERVALO = 10
RAM_SIZE = 100
INSTRUCTIONS = 1
PROCESOS = 25
TIEMPO = 3000.0
TIEMPOS = []

# Inicialización de la semilla 
random.seed(RANDOM_SEED)

# Función - Generar Procesos 
def generar_proceso(env, nombre, ram, cpu, instrucciones):
    # Cantidad de memoria para el proceso
    memoria_necesaria = random.randint(1, 10)
    print(f"Proceso {nombre} <NUEVO> - Tiempo: {env.now:.1f}")
    # Solicitud de memoria 
    with ram.get(memoria_necesaria) as req:
        yield req
        print(f"Proceso {nombre} <LISTO> - Tiempo: {env.now:.1f}")
        tiempo_llegada_proceso = env.now
        yield env.timeout(0)
        # Si no hay suficiente memoria RAM
        if ram.level < memoria_necesaria:
            print(f"Proceso {nombre} <ESPERANDO> - Tiempo: {env.now:.1f}")
        # Ciclo para la ejecución 
        while instrucciones > 0:
            with cpu.request() as req:
                yield req
                print(f"Proceso {nombre} <CORRIENDO> - Tiempo: {env.now:.1f}")
                # Tiempo Restante
                tiempo_restante = min(instrucciones, INSTRUCTIONS)
                instrucciones -= tiempo_restante
                yield env.timeout(tiempo_restante)
        # Tiempo de finalizacion
        tiempo_finalizacion_proceso = env.now
        tiempo_proceso = tiempo_finalizacion_proceso - tiempo_llegada_proceso
        print(f"Proceso {nombre} <TERMINADO> - Tiempo: {env.now:.1f}")
        #Agregar a la lista el tiempo que se tardo en realizar el proceso 
        TIEMPOS.append(tiempo_proceso)
        # Liberación de la memoria RAM 
        yield ram.put(memoria_necesaria)

# Creación del entorno 
env = simpy.Environment()

# Creación del contenedor para la memoria RAM y el recurso de la CPU
ram = simpy.Container(env, init=RAM_SIZE, capacity=RAM_SIZE)
cpu = simpy.Resource(env, capacity=2)

#Generación de Procesos 
for i in range(PROCESOS):
    env.process(generar_proceso(env, f"{i}", ram, cpu, random.expovariate(1.0 / INTERVALO)))

#Tiempo de trabajo del entorno
env.run(until=TIEMPO)

#Variables para las estadisticas del programa 
promedio = statistics.mean(TIEMPOS)
desviacion_estandar = statistics.stdev(TIEMPOS)

#Impresión de las estadisticas calculadas 
print("\n ***ESTADISTICAS*** \n")
print(f"Tiempo promedio de los procesos en la computadora: {promedio:.1f}")
print(f"Desviación estándar de los tiempos de los procesos: {desviacion_estandar:.1f}")





