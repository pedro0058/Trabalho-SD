import React, {useEffect, useState} from 'react';
import axios from 'axios';

function MyComponent() {
  const [id, setId] = useState('')
  const [nomeSensor ,setNomeSensor] = useState('');
  const [leitura, setLeitura] = useState('');

  useEffect(() => {
    fetchData();

    //Define um intervalo de 1 segundo (1000 ms)
    const interval = setInterval(() => {
      fetchData(); //chama a função fetchData a cada 5 segunos
    }, 1000);

    // limpa o intervalo quando o componente for desmontado
    return () => {
      clearInterval(interval);
    };

  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/leituras'); //URL da api spring boot
      const data = response.data;

      setId(data.id);
      setNomeSensor(data.nome);
      setLeitura(data.valor);
    } catch (error) {
      console.error('Erro ao receber dados da API', error)
    }
  };

  return (
    <div>
      <h1>Monitoramento do sistema IoT</h1>
      <p>Nome do Sensor: {nomeSensor}</p>
      <p>Id do Sensor: {id}</p>
      <p>Temperatura: {leitura.toFixed(2)} ºC</p>
    </div>
  );

}

export default MyComponent;