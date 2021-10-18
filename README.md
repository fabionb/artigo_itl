# Resolvendo "enq: TX - allocate ITL entry" com uma abordagem alternativa
Este repositório foi utilizado para a escrita do artigo sobre como resolver o evento de contenção de allocate ITL entry do Oracle de uma forma alternativa.

## Requisitos
Rodar um Oracle com o seguinte comando:
```
docker run -d --name oracle --network host -e ORACLE_ALLOW_REMOTE=true oracleinanutshell/oracle-xe-11g
```

## Execução
Para rodar o código, executar o seguinte comando:
```
./gradlew bootRun
```

## URL's
Utilizar as seguintes URL's para verificar o comportamento do Hibernate. É importante notar nos logs os pontos onde os insert's são feitos:

http://localhost:8081/flush

http://localhost:8081/withoutFlush

http://localhost:8081/nativeQuery

http://localhost:8081/nativeQueryWithQuerySpace

http://localhost:8081/nativeQueryWithQuerySpaceFromSameEntity

http://localhost:8081/queryTest2

http://localhost:8081/queryTest1
