# Projet Big Data Temps Réel — Kafka → Elasticsearch → Kibana

## 🎓 Contexte  
Ce projet a été réalisé dans le cadre du Master 1 Expert IT – Développement Web & Big Data à l’école IRIS Paris.  
Il s'agit d'une démonstration d'une pipeline temps réel complète, depuis la production de messages Kafka jusqu’à leur visualisation dans Kibana.

## 📌 Objectif  
Créer une mini-application capable de :  
- Récupérer des taux de change simulés  
- Publier ces données dans Kafka via Spring Boot  
- Les consommer et les indexer dans Elasticsearch  
- Les visualiser dans Kibana à travers Discover  

## ⚙️ Technologies utilisées  
| Composant       | Version utilisée        |  
|------------------|-------------------------|  
| Java             | 23.0.1 (Oracle)         |  
| Spring Boot      | 3.1.0                   |  
| Apache Kafka     | 3.9.1 (Scala 2.13)      |  
| Elasticsearch    | 8.13.4                  |  
| Kibana           | 8.13.4                  |  
| Maven            | 3.9.9                   |  
| OS               | macOS 15.4.1 (x86_64)   |  

## 🛠️ Lancement du projet  

### 1. Lancer Zookeeper + Kafka  
```bash  
cd ~/Downloads/bigdata-kafka/kafka_2.13-3.9.1  
bin/zookeeper-server-start.sh config/zookeeper.properties  
bin/kafka-server-start.sh config/server.properties  
```  

### 2. Lancer Elasticsearch  
```bash  
cd ~/Downloads/elasticsearch-8.13.4  
./bin/elasticsearch  
```  

### 3. Lancer Kibana  
```bash  
cd ~/Downloads/kibana-8.13.4  
./bin/kibana  
```  

### 4. Lancer l’application Spring Boot  
```bash  
cd ~/Downloads/kafka-spring-project  
mvn spring-boot:run  
```  

## 🔍 Visualisation dans Kibana  
1. Aller sur : [http://localhost:5601](http://localhost:5601)  
2. Aller dans **Stack Management > Data Views**  
3. Créer un Data View avec `exchangerates*` comme pattern  
4. Aller dans **Discover** pour visualiser les messages  

## 📦 Exemple de message publié  
```json  
{  
  "currency": "USD",  
  "rate": 10.3,  
  "timestamp": "2025-06-08T01:32:00Z"  
}  
```  

## 🙋‍♂️ Réalisé par  
- **Nom :** Alae Berrada  
- **Étudiant M1** à IRIS Paris  
- **Promo :** 2024-2025  
- **Projet encadré par :** Kodjo EDAH  

