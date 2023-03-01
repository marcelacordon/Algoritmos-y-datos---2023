# Autores: Marcela Cordon, Diego Duarte y Sofia Garcia 
# 28/02/2023
# Objetivo: Simulacion de una memoria RAM 

import simpy
import random
import statistics

RANDOM_SEED = 42
INTERVALO = 10
RAM_SIZE = 100
INSTRUCTIONS = 1
PROCESOS = 25
TIEMPO = 3000.0

random.seed(RANDOM_SEED)

def generar_proceso(env, nombre, ram, cpu, instrucciones):
    memoria_necesaria = random.randint(1, 10)
    print(f"Proceso {nombre} <NUEVO> - Tiempo: {env.now:.1f}") 
    with ram.get(memoria_necesaria) as req:
        yield req
        print(f"Proceso {nombre} <LISTO> - Tiempo: {env.now:.1f}")
        tiempo_llegada_proceso = env.now
        yield env.timeout(0)
        if ram.level < memoria_necesaria:
            print(f"Proceso {nombre} <ESPERANDO> - Tiempo: {env.now:.1f}") 
        while instrucciones > 0:
            with cpu.request() as req:
                yield req
                print(f"Proceso {nombre} <CORRIENDO> - Tiempo: {env.now:.1f}")
                tiempo_restante = min(instrucciones, INSTRUCTIONS)
                instrucciones -= tiempo_restante
                yield env.timeout(tiempo_restante)
        tiempo_finalizacion_proceso = env.now
        tiempo_proceso = tiempo_finalizacion_proceso - tiempo_llegada_proceso
        print(f"Proceso {nombre} <TERMINADO> - Tiempo: {env.now:.1f}")
        yield ram.put(memoria_necesaria)









