package eu.cloudtm.autonomicManager.simulator;

import eu.cloudtm.autonomicManager.commons.EvaluatedParam;
import eu.cloudtm.autonomicManager.commons.ForecastParam;
import eu.cloudtm.autonomicManager.commons.Param;
import eu.cloudtm.autonomicManager.commons.ReplicationProtocol;
import eu.cloudtm.autonomicManager.oracles.InputOracle;

/**
 * @author Sebastiano Peluso
 */
class SimulatorConfGlobal {

   private Integer cacheObjects;
   private Integer numServers;
   private Integer numClients;
   private Integer objectReplicationDegree;
   private Long startStatTime;
   private Long averageServerToServerNetDelay;    //TODO
   private Long averageClientToServerNetDelay;    //TODO

   ReplicationProtocol replicationProtocol;

   SimulatorConfGlobal(InputOracle inputOracle) {

      cacheObjects = toInt(inputOracle.getParam(Param.NumberOfEntries));
      numServers = toInt(inputOracle.getForecastParam(ForecastParam.NumNodes));
      numClients = toInt(inputOracle.getEvaluatedParam(EvaluatedParam.MAX_ACTIVE_THREADS)) * numServers;
      objectReplicationDegree = toInt(inputOracle.getForecastParam(ForecastParam.ReplicationDegree));

      replicationProtocol = (ReplicationProtocol) inputOracle.getForecastParam(ForecastParam.ReplicationProtocol);


      startStatTime = 0L;
      averageServerToServerNetDelay = 0L;
      averageClientToServerNetDelay = 0L;


   }

   ReplicationProtocol getReplicationProtocol(){
      return replicationProtocol;
   }

   int getNumberOfClients() {
      return numClients;
   }

   private int toInt(Object o) {
      return ((Number) o).intValue();
   }

   @Override
   public String toString() {

      return "[Global]\n\n" +
              "cache_objects = " + cacheObjects + "\n" +
              "num_servers = " + numServers + "\n" +
              "num_clients = " + numClients + "\n" +
              "object_replication_degree = " + objectReplicationDegree + "\n" +
              "start_stat_time = " + startStatTime + "\n" +
              "average_server_to_server_net_delay = " + averageServerToServerNetDelay + "\n" +
              "average_client_to_server_net_delay = " + averageClientToServerNetDelay;


   }

}
