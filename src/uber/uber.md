## Ride-Sharing System Design — Quick Revision Notes

### 1. ETA Calculation

- Road network: Represent the road network as a graph (nodes = intersections, edges = roads).
- Dijkstra: Finds the shortest path but may explore many unnecessary nodes.
- A\* algorithm: Uses a heuristic (e.g., straight-line distance) to guide the search toward the destination.
- Graph partitioning: Divide the road network into smaller regions to reduce search space.
- Precomputation: Speeds up routing, but dynamic traffic and road closures require updates.
- DeepETA: ML post-processing model that refines the routing engine's baseline ETA using traffic patterns and historical data.

### 2. TTL (Time to Live)

- Prevents ride requests from remaining pending indefinitely.
- If no driver accepts before expiry, mark the request `EXPIRED` or retry matching.
- Handle race conditions between acceptance and expiration.

### 3. Geospatial Indexing

- Enables efficient searches for nearby available drivers without scanning all drivers.
- Geohashing: Converts latitude/longitude into geographic cells.
- Search the current and neighboring cells, then filter candidates by actual distance, availability, and vehicle type.

### 4. Haversine formula to calculate the distance of rider to driver

- double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
        + Math.cos(lat1) * Math.cos(lat2)
        * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

- double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
- double distance = 6371.0 * c;

- <img width="961" height="560" alt="image" src="https://github.com/user-attachments/assets/6b990d08-c253-48f6-85cf-5f2048277084" />
